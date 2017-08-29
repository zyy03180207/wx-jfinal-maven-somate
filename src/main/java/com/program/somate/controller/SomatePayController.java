package com.program.somate.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.jfinal.kit.PropKit;
import com.jfinal.kit.StrKit;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.api.ApiConfigKit;
import com.jfinal.weixin.sdk.api.JsTicketApi;
import com.jfinal.weixin.sdk.api.PaymentApi;
import com.jfinal.weixin.sdk.api.SnsAccessToken;
import com.jfinal.weixin.sdk.api.SnsAccessTokenApi;
import com.jfinal.weixin.sdk.api.JsTicketApi.JsApiType;
import com.jfinal.weixin.sdk.api.PaymentApi.TradeType;
import com.jfinal.weixin.sdk.jfinal.ApiController;
import com.jfinal.weixin.sdk.kit.IpKit;
import com.jfinal.weixin.sdk.kit.PaymentKit;
import com.jfinal.weixin.sdk.utils.JsonUtils;
import com.program.somate.util.WeixinUtil;

/**
 * 微信支付调用
 * 
 * @author yangyang.zhang
 * @Package com.program.somate.controller
 * @Date 2017年8月24日 下午1:55:18
 * @Description TODO(用一句话描述该文件做什么)
 * @version V1.0
 */
public class SomatePayController extends ApiController {

	Logger logger = Logger.getLogger(SomatePayController.class);

	@Override
	public ApiConfig getApiConfig() {
		// TODO Auto-generated method stub
		return WeixinUtil.getPayApiConfig();
	}

	public void wxpay() {
		String code = getPara("code");
		SnsAccessToken accessToken = SnsAccessTokenApi.getSnsAccessToken(PropKit.get("payAppId"), PropKit.get("payAppSecret"),
				code);
		String nonceStr = WeixinUtil.getRandomString(16);
		String timestamp = WeixinUtil.getTimeStamp();
		TreeMap<String, String> paramMap = new TreeMap<String, String>();
		paramMap.put("jsapi_ticket", JsTicketApi.getTicket(JsApiType.jsapi).getTicket());
		paramMap.put("noncestr", nonceStr);
		paramMap.put("timestamp", timestamp);
		paramMap.put("url", WeixinUtil.getUrl(this));
		this.setAttr("nonceStr", nonceStr);
		this.setAttr("timestamp", timestamp);
		this.setAttr("signature", WeixinUtil.getSign(paramMap));
		this.setAttr("appId", PropKit.get("payAppId"));
		logger.info("jsapi_ticket=[" + JsTicketApi.getTicket(JsApiType.jsapi).getTicket() + "]-----nonceStr=["
				+ nonceStr + "]-----timestamp=[" + timestamp + "],url=[" + WeixinUtil.getUrl(this) + "]-----appId=["
				+ PropKit.get("payAppId") + "]");
		this.setAttr("openId", accessToken.getOpenid());
		renderJsp("vip_recharge.jsp");
	}

	public void topay() {
		// 统一下单文档地址：https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_1
		String appid = ApiConfigKit.getApiConfig().getAppId();
		logger.info("appId=" + appid);
		String partner = PropKit.get("mch_id");
		String openId = this.getPara("openId");
		String paternerKey = PropKit.get("key");
		Map<String, String> params = new HashMap<String, String>();
		params.put("appid", appid);
		params.put("mch_id", partner);
		params.put("body", "Somates会员充值");
		params.put("out_trade_no", WeixinUtil.getOrder());
		params.put("total_fee", "100");

		String ip = IpKit.getRealIp(getRequest());
		if (StrKit.isBlank(ip)) {
			ip = "127.0.0.1";
		}

		params.put("spbill_create_ip", ip);
		params.put("trade_type", TradeType.JSAPI.name());
		params.put("nonce_str", System.currentTimeMillis() / 1000 + "");
		params.put("notify_url", "https://programafter.com/wx-jfinal-maven-somate");
		params.put("openid", openId);

		String sign = PaymentKit.createSign(params, paternerKey);
		params.put("sign", sign);
		String xmlResult = PaymentApi.pushOrder(params);

		System.out.println(xmlResult);
		Map<String, String> result = PaymentKit.xmlToMap(xmlResult);

		String return_code = result.get("return_code");
		String return_msg = result.get("return_msg");
		if (StrKit.isBlank(return_code) || !"SUCCESS".equals(return_code)) {
			renderText(return_msg);
			return;
		}
		String result_code = result.get("result_code");
		if (StrKit.isBlank(result_code) || !"SUCCESS".equals(result_code)) {
			renderText(return_msg);
			return;
		}
		// 以下字段在return_code 和result_code都为SUCCESS的时候有返回
		String prepay_id = result.get("prepay_id");
		logger.info("prepay_id=" + prepay_id);
		Map<String, String> packageParams = new HashMap<String, String>();
		packageParams.put("appId", appid);
		packageParams.put("timeStamp", System.currentTimeMillis() / 1000 + "");
		packageParams.put("nonceStr", System.currentTimeMillis() + "");
		packageParams.put("package", "prepay_id=" + prepay_id);
		packageParams.put("signType", "MD5");
		String packageSign = PaymentKit.createSign(packageParams, paternerKey);
		packageParams.put("paySign", packageSign);
		String jsonStr = JsonUtils.toJson(packageParams);
		renderJson(jsonStr);
	}

}
