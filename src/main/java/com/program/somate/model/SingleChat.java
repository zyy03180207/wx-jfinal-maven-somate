package com.program.somate.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

public class SingleChat extends Model<SingleChat> {
	private static final long serialVersionUID = -5705309079867084733L;
	public static final SingleChat dao = new SingleChat();

	public SingleChat findByCondition(String age, String sex, String city, String openId) {
		String sql = "SELECT * FROM tb_single_chat t WHERE {1}  {2}  {3} t.ishandle = 'A' AND myopenid <> ?";
		if (age != null) {
			sql = sql.replaceAll("{1}", "t.age ='" + age + "' AND");
		}
		if (sex != null) {
			sql = sql.replaceAll("{2}", "t.sex ='" + sex + "' AND");
		}
		if (city != null) {
			sql = sql.replaceAll("{3}", "t.city ='" + city + "' AND");
		}
		sql = sql.replaceAll("\\{\\d\\}", "");
		return dao.findFirst(sql, openId);
	}

	public SingleChat findByHandle(String openId, String handle) {
		String sql = "SELECT * FROM tb_single_chat t WHERE t.ishandle = ? AND myopenid = ?";
		return dao.findFirst(sql, handle, openId);
	}

	public SingleChat findByMyOpenId(String openId) {
		String sql = "SELECT * FROM tb_single_chat WHERE myopenid = ? AND ishandle = 'B'";
		return dao.findFirst(sql, openId);
	}

	public List<SingleChat> findByHandleList(String myopenid, String handle) {
		String sql = "SELECT * FROM tb_single_chat t WHERE t.myopenid = ? OR t.openid = ? AND t.ishandle = ?";
		return dao.find(sql, myopenid, myopenid, handle);
	}
}
