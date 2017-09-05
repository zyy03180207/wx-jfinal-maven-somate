package com.program.somate.selector;

import java.util.Date;

import com.jfinal.weixin.sdk.msg.in.InMsg;
import com.jfinal.weixin.sdk.msg.in.InTextMsg;
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
			if (inMsg instanceof InTextMsg) {
				InTextMsg textMsg = (InTextMsg) inMsg;
				if ("退出".equals(textMsg.getContent())) {
					outMsg = singleChat.exitSingleChat();
				} else {
					outMsg = singleChat.distributeChat();
				}
			} else {
				outMsg = singleChat.distributeChat();
			}
			break;

		default:
			outMsg = new OutTextMsg(inMsg).setContent(Common.TITLE + "您还未使用任何功能！");
			break;
		}
		return outMsg;
	}
}
