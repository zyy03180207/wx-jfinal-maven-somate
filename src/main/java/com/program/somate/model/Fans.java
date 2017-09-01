package com.program.somate.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * 粉丝
 * 
 * @author yangyang.zhang
 * @Package com.program.somate.model
 * @Date 2017年9月1日 下午1:59:54
 * @Description TODO(用一句话描述该文件做什么)
 * @version V1.0
 */
public class Fans extends Model<Fans> {

	private static final long serialVersionUID = -8131217552732975810L;

	public static final Fans dao = new Fans();

	public Fans findByOpenId(String openId) {
		String sql = "SELECT * FROM tb_fans WHERE openid = ?";
		return dao.findFirst(sql, openId);
	}
}
