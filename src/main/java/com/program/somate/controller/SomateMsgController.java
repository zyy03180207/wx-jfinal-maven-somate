package com.program.somate.controller;

import org.apache.log4j.Logger;

import com.jfinal.weixin.sdk.api.AccessTokenApi;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.api.ApiResult;
import com.jfinal.weixin.sdk.api.UserApi;
import com.jfinal.weixin.sdk.jfinal.MsgController;
import com.jfinal.weixin.sdk.jfinal.MsgControllerAdapter;
import com.jfinal.weixin.sdk.msg.in.InImageMsg;
import com.jfinal.weixin.sdk.msg.in.InLinkMsg;
import com.jfinal.weixin.sdk.msg.in.InLocationMsg;
import com.jfinal.weixin.sdk.msg.in.InNotDefinedMsg;
import com.jfinal.weixin.sdk.msg.in.InShortVideoMsg;
import com.jfinal.weixin.sdk.msg.in.InTextMsg;
import com.jfinal.weixin.sdk.msg.in.InVideoMsg;
import com.jfinal.weixin.sdk.msg.in.InVoiceMsg;
import com.jfinal.weixin.sdk.msg.in.event.InCustomEvent;
import com.jfinal.weixin.sdk.msg.in.event.InFollowEvent;
import com.jfinal.weixin.sdk.msg.in.event.InLocationEvent;
import com.jfinal.weixin.sdk.msg.in.event.InMassEvent;
import com.jfinal.weixin.sdk.msg.in.event.InMenuEvent;
import com.jfinal.weixin.sdk.msg.in.event.InMerChantOrderEvent;
import com.jfinal.weixin.sdk.msg.in.event.InNotDefinedEvent;
import com.jfinal.weixin.sdk.msg.in.event.InPoiCheckNotifyEvent;
import com.jfinal.weixin.sdk.msg.in.event.InQrCodeEvent;
import com.jfinal.weixin.sdk.msg.in.event.InShakearoundUserShakeEvent;
import com.jfinal.weixin.sdk.msg.in.event.InSubmitMemberCardEvent;
import com.jfinal.weixin.sdk.msg.in.event.InTemplateMsgEvent;
import com.jfinal.weixin.sdk.msg.in.event.InUpdateMemberCardEvent;
import com.jfinal.weixin.sdk.msg.in.event.InUserPayFromCardEvent;
import com.jfinal.weixin.sdk.msg.in.event.InUserViewCardEvent;
import com.jfinal.weixin.sdk.msg.in.event.InVerifyFailEvent;
import com.jfinal.weixin.sdk.msg.in.event.InVerifySuccessEvent;
import com.jfinal.weixin.sdk.msg.in.event.InWifiEvent;
import com.jfinal.weixin.sdk.msg.in.speech_recognition.InSpeechRecognitionResults;
import com.jfinal.weixin.sdk.msg.out.OutNewsMsg;
import com.jfinal.weixin.sdk.msg.out.OutTextMsg;
import com.program.somate.model.Fans;
import com.program.somate.model.WxConfig;
import com.program.somate.util.WeixinUtil;

/**
 * 接收微信消息推送
 * 
 * @author yangyang.zhang
 * @Package com.program.somate.controller
 * @Date 2017年8月24日 下午1:42:04
 * @Description TODO(接收微信消息推送)
 * @version V1.0
 */
public class SomateMsgController extends MsgController {

	Logger logger = Logger.getLogger(SomateMsgController.class);

	@Override
	public ApiConfig getApiConfig() {
		// TODO Auto-generated method stub
		return WeixinUtil.getApiConfig();
	}

	@Override
	protected void processInTextMsg(InTextMsg inTextMsg) {
		// TODO Auto-generated method stub
		OutTextMsg outTextMsg = new OutTextMsg(inTextMsg);
		outTextMsg.setContent("你好");
		logger.info("accessToken=" + AccessTokenApi.getAccessTokenStr());
		render(outTextMsg);
	}

	@Override
	protected void processInImageMsg(InImageMsg inImageMsg) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInVoiceMsg(InVoiceMsg inVoiceMsg) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInVideoMsg(InVideoMsg inVideoMsg) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInShortVideoMsg(InShortVideoMsg inShortVideoMsg) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInLocationMsg(InLocationMsg inLocationMsg) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInLinkMsg(InLinkMsg inLinkMsg) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInCustomEvent(InCustomEvent inCustomEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInFollowEvent(InFollowEvent inFollowEvent) {
		// TODO Auto-generated method stub
		OutTextMsg msg = new OutTextMsg(inFollowEvent);
		// 获取OpenId
		logger.info("----------微信公众号关注事件开始----------");
		String openId = inFollowEvent.getFromUserName();
		if (inFollowEvent.getEvent().equals(InFollowEvent.EVENT_INFOLLOW_SUBSCRIBE)) {
			// 关注事件
			logger.info("----------关注----------");
			ApiResult result = UserApi.getUserInfo(openId);
			logger.info("userInfo----->" + result.toString());
			if (result != null) {
				Fans fans = new Fans();
				fans.set("subscribe", result.get("subscribe")).set("openid", result.get("openid"))
						.set("nickname", result.get("nickname")).set("sex", result.get("sex"))
						.set("city", result.get("city")).set("province", result.get("province"))
						.set("country", result.get("country")).set("language", result.get("language"))
						.set("headimgurl", result.get("headimgurl")).set("subscribe_time", result.get("subscribe_time"))
						.set("unionid", result.get("unionid")).set("remark", result.get("remark"))
						.set("groupid", result.get("groupid")).set("tagid_list", result.get("tagid_list"));
				fans.save();
			} else {
				logger.error("获取用户信息异常：---->openId=[" + openId + "]");
			}
			WxConfig wxConfig = WxConfig.dao.findByKey("FOLLOW_RETURN");
			if (wxConfig != null) {
				msg.setContent(wxConfig.getStr("cfgVal"));
			} else {
				msg.setContent("欢迎关注Somates平台");
			}
		} else if (inFollowEvent.getEvent().equals(InFollowEvent.EVENT_INFOLLOW_UNSUBSCRIBE)) {
			logger.info("----------取消关注----------");
			Fans fans = Fans.dao.findByOpenId(openId);
			if (fans != null) {
				fans.set("subscribe", "0").update();
			}
			// 取消关注事件
			renderText("success");
		} else {
			logger.info("----------未知操作类型----------");
			renderText("success");
		}
		logger.info("----------微信公众号关注事件结束----------");
		render(msg);
	}

	@Override
	protected void processInQrCodeEvent(InQrCodeEvent inQrCodeEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInLocationEvent(InLocationEvent inLocationEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInMassEvent(InMassEvent inMassEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInMenuEvent(InMenuEvent inMenuEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInSpeechRecognitionResults(InSpeechRecognitionResults inSpeechRecognitionResults) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInTemplateMsgEvent(InTemplateMsgEvent inTemplateMsgEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInShakearoundUserShakeEvent(InShakearoundUserShakeEvent inShakearoundUserShakeEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInVerifySuccessEvent(InVerifySuccessEvent inVerifySuccessEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInVerifyFailEvent(InVerifyFailEvent inVerifyFailEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInPoiCheckNotifyEvent(InPoiCheckNotifyEvent inPoiCheckNotifyEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInWifiEvent(InWifiEvent inWifiEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInUserViewCardEvent(InUserViewCardEvent inUserViewCardEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInSubmitMemberCardEvent(InSubmitMemberCardEvent inSubmitMemberCardEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInUpdateMemberCardEvent(InUpdateMemberCardEvent inUpdateMemberCardEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInUserPayFromCardEvent(InUserPayFromCardEvent inUserPayFromCardEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInMerChantOrderEvent(InMerChantOrderEvent inMerChantOrderEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processIsNotDefinedEvent(InNotDefinedEvent inNotDefinedEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processIsNotDefinedMsg(InNotDefinedMsg inNotDefinedMsg) {
		// TODO Auto-generated method stub

	}

}
