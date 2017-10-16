package com.program.somate.controller;

import com.jfinal.kit.PropKit;
import com.jfinal.weixin.sdk.api.ApiResult;
import com.jfinal.weixin.sdk.api.SnsAccessToken;
import com.jfinal.weixin.sdk.api.SnsAccessTokenApi;
import com.jfinal.weixin.sdk.api.UserApi;
import com.program.somate.model.Fans;
import com.program.somate.util.StringUtil;

public class SomateIndexController extends BaseController {

	public void index() {
		
	}
	/**
	 * 报名页面
	 */
	public void signUp() {
		renderJsp("signup.jsp");
	}
	/**
	 * 我的页面
	 */
	public void mine() {
		String openId = (String) getSession().getAttribute("openId");
		if (!StringUtil.strisNotNull(openId)) {
			String code = getPara("code");
			SnsAccessToken accessToken = SnsAccessTokenApi.getSnsAccessToken(PropKit.get("appId"),
					PropKit.get("appSecret"), code);
			openId = accessToken.getOpenid();
			getSession().setAttribute("openId", openId);
		}
		logger.info("我的页面------>openId=[" + openId + "]");
		if (StringUtil.strisNotNull(openId)) {
			Fans fans = Fans.dao.findByOpenId(openId);
			if (fans == null) {
				ApiResult result = UserApi.getUserInfo(openId);
				logger.info("userInfo----->" + result.toString());
				if (result != null) {
					fans = new Fans();
					fans.set("subscribe", result.get("subscribe")).set("openid", result.get("openid"))
							.set("nickname", result.get("nickname")).set("sex", result.get("sex"))
							.set("city", result.get("city")).set("province", result.get("province"))
							.set("country", result.get("country")).set("language", result.get("language"))
							.set("headimgurl", result.get("headimgurl"))
							.set("subscribe_time", result.get("subscribe_time")).set("unionid", result.get("unionid"))
							.set("remark", result.get("remark")).set("groupid", result.get("groupid"));
					fans.save();
				} else {
					logger.error("获取用户信息异常：---->openId=[" + openId + "]");
				}
			}
			setAttr("userInfo", fans);
		}
		renderJsp("mine.jsp");
	}
}
