package com.program.somate.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * 微信配置表
 * @author yangyang.zhang
 * @Package com.program.somate.model
 * @Date 2017年9月1日 上午11:35:58
 * @Description TODO(用一句话描述该文件做什么)
 * @version V1.0
 */
public class WxConfig extends Model<WxConfig> {

	private static final long serialVersionUID = -1903599717163453674L;
	
	public static final WxConfig dao = new WxConfig();

	public WxConfig findByKey(String key) {
		String sql = "SELECT * FROM tb_wx_config WHERE cfgKey = ?";
		return dao.findFirst(sql, key);
	}
}
