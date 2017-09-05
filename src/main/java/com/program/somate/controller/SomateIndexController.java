package com.program.somate.controller;

import java.util.TreeMap;

import com.jfinal.kit.PropKit;
import com.jfinal.weixin.sdk.api.JsTicketApi;
import com.jfinal.weixin.sdk.api.JsTicketApi.JsApiType;
import com.program.somate.util.WeixinUtil;

public class SomateIndexController extends BaseController {

	public void index() {
		String url = this.getRequest().getRequestURL().toString();
		String nonceStr = WeixinUtil.getRandomString(16);
		String timestamp = WeixinUtil.getTimeStamp();
		TreeMap<String, String> paramMap = new TreeMap<String, String>();
		paramMap.put("jsapi_ticket", JsTicketApi.getTicket(JsApiType.jsapi).getTicket());
		paramMap.put("nonceStr", nonceStr);
		paramMap.put("timestamp", timestamp);
		paramMap.put("url", url);
		this.setAttr("nonceStr", nonceStr);
		this.setAttr("timestamp", timestamp);
		this.setAttr("signature", WeixinUtil.getSign(paramMap));
		this.setAttr("appId", PropKit.get("appId"));
		logger.info("jsapi_ticket=[" + JsTicketApi.getTicket(JsApiType.jsapi).getTicket() + "]-----nonceStr=["
				+ nonceStr + "]-----timestamp=[" + timestamp + "],url=[" + url + "]-----appId=["
				+ PropKit.get("appId") + "]");
		renderJsp("pages/vip_recharge.jsp");
	}

	public void signUp() {
		renderJsp("signup.jsp");
	}
	
}
