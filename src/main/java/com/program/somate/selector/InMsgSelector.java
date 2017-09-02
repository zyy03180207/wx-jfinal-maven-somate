package com.program.somate.selector;

import java.util.Date;

import com.jfinal.weixin.sdk.msg.in.InMsg;
import com.jfinal.weixin.sdk.msg.out.OutMsg;
import com.jfinal.weixin.sdk.msg.out.OutTextMsg;
import com.program.somate.config.Common;
import com.program.somate.model.NowFunction;
import com.program.somate.selector.fun.SingleChatFun;

public class InMsgSelector extends BaseSelector {

	public InMsgSelector(InMsg inMsg) {
		super(inMsg);
	}

	@Override
	public OutMsg exect() {
		OutMsg outMsg = null;
		String openId = inMsg.getFromUserName();
		NowFunction function = NowFunction.dao.findByOpenId(openId);
		if (function == null) {
			function = new NowFunction().set("openid", openId).set("function", "NONE").set("createdate", new Date());
			function.save();
			outMsg = new OutTextMsg(inMsg).setContent(Common.TITLE + "您还未使用任何功能！");
			return outMsg;
		}
		switch (function.getStr("function")) {
		case Common.SINGLECHAT:
			SingleChatFun singleChat = new SingleChatFun(inMsg);
			outMsg = singleChat.distributeChat();
			break;

		default:
			outMsg = new OutTextMsg(inMsg).setContent(Common.TITLE + "您还未使用任何功能！");
			break;
		}
		return outMsg;
	}
}
