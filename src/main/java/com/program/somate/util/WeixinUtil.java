package com.program.somate.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.log4j.Logger;

import com.jfinal.kit.PropKit;
import com.jfinal.weixin.sdk.api.ApiConfig;
/**
 * 公众平台通用接口工具类
 * @author yangyang.zhang
 * @Package com.program.somate.util 
 * @Date 2017年8月24日 下午1:50:39 
 * @Description TODO(公众平台通用接口工具类)
 * @version V1.0
 */
public class WeixinUtil {
	
	public static Logger logger = Logger.getLogger(WeixinUtil.class);
	
	/**
	 * 获取配置
	 */
	public static ApiConfig getApiConfig() {
		ApiConfig ac = new ApiConfig();

		// 配置微信 API 相关常量
		ac.setToken(PropKit.get("token"));
		ac.setAppId(PropKit.get("appId"));
		ac.setAppSecret(PropKit.get("appSecret"));
		logger.info("token=[" + PropKit.get("token") + "]-----appId=[" + PropKit.get("appId") + "]-----appSecret=[" + PropKit.get("appSecret") + "]");
		/**
		 *  是否对消息进行加密，对应于微信平台的消息加解密方式：
		 *  1：true进行加密且必须配置 encodingAesKey
		 *  2：false采用明文模式，同时也支持混合模式
		 */
		ac.setEncryptMessage(PropKit.getBoolean("encryptMessage", false));
		ac.setEncodingAesKey(PropKit.get("encodingAesKey", "setting it in config file"));
		return ac;
	}

	/**
	 * emoji表情转换(hex -> utf-16)
	 *
	 * @param hexEmoji
	 * @return
	 */
	public static String emoji(int hexEmoji) {
		return String.valueOf(Character.toChars(hexEmoji));
	}

	/**
	 * UTF-8编码
	 *
	 * @param source
	 * @return
	 */
	public static String urlEncodeUTF8(String source) {
		try {
			return URLEncoder.encode(source, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

}