package com.program.somate.selector.fun;

import java.util.Date;

import com.jfinal.weixin.sdk.msg.in.InMsg;
/**
 * 单聊功能
 * @author yangyang.zhang
 * @Package com.program.somate.selector.fun 
 * @Date 2017年9月1日 下午6:49:23 
 * @Description TODO(用一句话描述该文件做什么)
 * @version V1.0
 */
import com.jfinal.weixin.sdk.msg.out.OutMsg;
import com.jfinal.weixin.sdk.msg.out.OutTextMsg;
import com.program.somate.config.Common;
import com.program.somate.model.SingleChat;

public class SingleChatFun extends BaseFun {

	public SingleChatFun(InMsg inMsg) {
		super(inMsg);
	}

	/**
	 * 创建单聊事件
	 * 
	 * @return
	 */
	public OutMsg matchSingleChat() {
		OutMsg outMsg = null;
		String openId = inMsg.getFromUserName();
		// 获取自己的匹配条件
		// 获取符合条件的人
		SingleChat singleChat = SingleChat.dao.findByCondition(null, null, null);
		if (singleChat == null) {
			singleChat = new SingleChat();
			singleChat.set("myopenid", openId).set("createtime", new Date()).set("ishandle", "A").set("age", null)
					.set("sex", "").set("city", "").save();
			outMsg = new OutTextMsg(inMsg).setContent(Common.TITLE + "正在为你匹配搭讪目标，请耐心等待");
			return outMsg;
		}
		singleChat.set("openid", openId).set("ishandle", "B").update();
		SingleChat chat = new SingleChat();
		chat.set("myopenid", openId).set("createtime", new Date()).set("ishandle", "B").set("age", "").set("sex", "")
				.set("city", "").save();
		return outMsg;
	}

	public OutMsg distributeChat() {

		return null;
	}

}
