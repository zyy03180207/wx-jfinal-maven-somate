package com.program.somate.selector.fun;

import com.jfinal.weixin.sdk.msg.in.InMsg;
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

}
