package com.program.somate.selector;

import com.jfinal.weixin.sdk.msg.in.InMsg;
import com.jfinal.weixin.sdk.msg.out.OutMsg;

public abstract class BaseSelector {

	public InMsg inMsg;

	public BaseSelector(InMsg inMsg) {
		this.inMsg = inMsg;
	}

	public abstract OutMsg exect();
}
