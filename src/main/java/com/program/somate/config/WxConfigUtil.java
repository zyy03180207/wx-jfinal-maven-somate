package com.program.somate.config;

import java.util.HashMap;
import java.util.Map;

import com.program.somate.model.WxConfig;
import com.program.somate.util.StringUtil;

public class WxConfigUtil {

	public static Map<String, String> map = new HashMap<String, String>();
	
	public static String getCfgKey (String key) {
		String val = map.get(key);
		if(!StringUtil.strisNotNull(val)) {
			WxConfig wxConfig = WxConfig.dao.findByKey(key);
			if(wxConfig != null) {
				val = wxConfig.getStr("cfgVal");
			}
		}
		return val;
	}
	
}
