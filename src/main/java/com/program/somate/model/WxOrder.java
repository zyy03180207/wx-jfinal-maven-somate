package com.program.somate.model;

import com.jfinal.plugin.activerecord.Model;
/**
 * 微信支付订单
 * @author yangyang.zhang
 * @Package com.program.somate.model 
 * @Date 2017年9月20日 下午5:14:35 
 * @Description TODO(用一句话描述该文件做什么)
 * @version V1.0
 */
public class WxOrder extends Model<WxOrder> {

	private static final long serialVersionUID = -5380557045856762305L;
	public static final WxOrder dao = new WxOrder();
}
