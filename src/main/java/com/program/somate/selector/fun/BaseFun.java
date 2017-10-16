package com.program.somate.selector.fun;

import java.util.Date;

import com.jfinal.weixin.sdk.msg.in.InMsg;
import com.program.somate.model.NowFunction;

/**
 * 所有功能的基类
 * @author yangyang.zhang
 * @Package com.program.somate.selector.fun
 * @Date 2017年9月1日 下午6:49:40
 * @Description TODO(用一句话描述该文件做什么)
 * @version V1.0
 */
public class BaseFun {

	public InMsg inMsg;

	public BaseFun(InMsg inMsg) {
		this.inMsg = inMsg;
	}
	//修改功能选项
	public void initFun(String fun) {
		NowFunction function = NowFunction.dao.findByOpenId(inMsg.getFromUserName());
		if (function == null) {
			function = new NowFunction();
			function.set("openid", inMsg.getFromUserName()).set("function", fun).set("createdate", new Date());
			function.save();
		} else {
			function.set("function", fun).update();
		}
	}

}
