package com.program.somate.controller;

import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.jfinal.ApiController;
import com.program.somate.util.WeixinUtil;
/**
 * 微信Api调用
 * @author yangyang.zhang
 * @Package com.program.somate.controller 
 * @Date 2017年8月24日 下午1:53:47 
 * @Description TODO(用一句话描述该文件做什么)
 * @version V1.0
 */
public class SomateApiController extends ApiController {

	@Override
	public ApiConfig getApiConfig() {
		// TODO Auto-generated method stub
		return WeixinUtil.getApiConfig();
	}

	
}
