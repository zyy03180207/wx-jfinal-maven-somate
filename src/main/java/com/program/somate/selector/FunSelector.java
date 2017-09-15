package com.program.somate.selector;

import com.jfinal.weixin.sdk.msg.in.InMsg;
import com.jfinal.weixin.sdk.msg.in.event.InMenuEvent;
import com.jfinal.weixin.sdk.msg.out.OutMsg;
import com.program.somate.config.Common;
import com.program.somate.selector.fun.SingleChatFun;
/**
 * 功能选择工具
 * @author yangyang.zhang
 * @Package com.program.somate.selector 
 * @Date 2017年9月15日 下午5:59:03 
 * @Description TODO(用一句话描述该文件做什么)
 * @version V1.0
 */
public class FunSelector extends BaseSelector {

	public FunSelector(InMsg inMsg) {
		super(inMsg);
	}
	
	@Override
	public OutMsg exect() {
		// TODO Auto-generated method stub
		OutMsg outMsg = null;
		InMenuEvent inMenuEvent = (InMenuEvent) inMsg;
		String eventKey = inMenuEvent.getEventKey();
		switch (eventKey) {
		//搭讪功能
		case Common.SINGLECHAT:
			SingleChatFun singleChat = new SingleChatFun(inMenuEvent);
			outMsg = singleChat.matchSingleChat();
			break;
			
		case "":
			
			break;
		default:
			break;
		}
		return outMsg;
	}
	

}
