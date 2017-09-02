package com.program.somate.selector.fun;

import java.util.Date;

import com.jfinal.weixin.sdk.api.CustomServiceApi;
import com.jfinal.weixin.sdk.msg.in.InMsg;
import com.jfinal.weixin.sdk.msg.in.InTextMsg;
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
import com.program.somate.model.Fans;
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
		// 获取符合条件的人（先不加入条件筛选）
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
		// 发起人的信息
		Fans fromFans = Fans.dao.findByOpenId(openId);
		// 被匹配人的信息
		Fans toFans = Fans.dao.findByOpenId(singleChat.getStr("myopenid"));
		CustomServiceApi.sendText(singleChat.getStr("myopenid"),
				Common.TITLE + "成功匹配到了[" + fromFans.getStr("nickname") + "]，直接在此处发信息和Ta聊天就可以了哦~\n回复【退出】结束聊天");
		outMsg = new OutTextMsg(inMsg)
				.setContent(Common.TITLE + "成功匹配到了[" + toFans.getStr("nickname") + "]，直接在此处发信息和Ta聊天就可以了哦~\n回复【退出】结束聊天");
		return outMsg;
	}

	public OutMsg distributeChat() {
		OutMsg outMsg = null;
		String msgType = inMsg.getMsgType();
		SingleChat chat = SingleChat.dao.findByMyOpenId(inMsg.getFromUserName());
		if(chat == null) {
			outMsg = new OutTextMsg(inMsg).setContent(Common.TITLE + "未匹配到对象");
			return outMsg;
		}
		switch (msgType) {
		case "text":
			InTextMsg inTextMsg = (InTextMsg) inMsg;
			CustomServiceApi.sendText(chat.getStr("openid"), inTextMsg.getContent());
			break;

		default:
			break;
		}
		return outMsg;
	}

}
