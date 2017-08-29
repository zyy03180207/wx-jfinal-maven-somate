package com.program.somate.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.jfinal.core.Controller;
import com.jfinal.kit.PropKit;
import com.jfinal.weixin.sdk.api.ApiConfig;

/**
 * 公众平台通用接口工具类
 * 
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
		logger.info("token=[" + PropKit.get("token") + "]-----appId=[" + PropKit.get("appId") + "]-----appSecret=["
				+ PropKit.get("appSecret") + "]");
		/**
		 * 是否对消息进行加密，对应于微信平台的消息加解密方式： 1：true进行加密且必须配置 encodingAesKey
		 * 2：false采用明文模式，同时也支持混合模式
		 */
		ac.setEncryptMessage(PropKit.getBoolean("encryptMessage", false));
		ac.setEncodingAesKey(PropKit.get("encodingAesKey", "setting it in config file"));
		return ac;
	}
	
	public static ApiConfig getPayApiConfig() {
		ApiConfig ac = new ApiConfig();

		// 配置微信 API 相关常量
		ac.setToken(PropKit.get("token"));
		ac.setAppId(PropKit.get("payAppId"));
		ac.setAppSecret(PropKit.get("payAppSecret"));
		logger.info("token=[" + PropKit.get("token") + "]-----appId=[" + PropKit.get("payAppId") + "]-----appSecret=["
				+ PropKit.get("payAppSecret") + "]");
		/**
		 * 是否对消息进行加密，对应于微信平台的消息加解密方式： 1：true进行加密且必须配置 encodingAesKey
		 * 2：false采用明文模式，同时也支持混合模式
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

	public static String getRandomString(int length) { // length表示生成字符串的长度
		String base = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	public static String getTimeStamp() {
		long timestamp = System.currentTimeMillis() / 1000;
		return timestamp + "";
	}

	public static String getSign(TreeMap<String, String> paramMap) {
		StringBuffer stringBuffer = new StringBuffer();
		SortedMap<String, String> smap = new TreeMap<String, String>(paramMap);
		for (Map.Entry<String, String> m : smap.entrySet()) {
			Object value = m.getValue();
			if (value != null && !"".equals(String.valueOf(value))) {
				stringBuffer.append(m.getKey()).append("=").append(m.getValue()).append("&");
			}
		}
		stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());

		String argPreSign = stringBuffer.toString();
		String signature = getSha1(argPreSign);
		return signature;
	}

	public static String getSha1(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
			mdTemp.update(str.getBytes("UTF-8"));

			byte[] md = mdTemp.digest();
			int j = md.length;
			char buf[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
				buf[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(buf);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public static String getOrder() {
		String order = "wx_0318" + System.currentTimeMillis();
		return order;
	}

	public static String getUrl(Controller controller) {
		HttpServletRequest httpRequest = (HttpServletRequest) controller.getRequest();
		StringBuffer url = new StringBuffer();
		url.append("https://programafter.com").append(httpRequest.getContextPath())
				.append(httpRequest.getServletPath());
		if (httpRequest.getQueryString() != null) {
			url.append("?" + httpRequest.getQueryString());
		}
		return url.toString();
	}
}