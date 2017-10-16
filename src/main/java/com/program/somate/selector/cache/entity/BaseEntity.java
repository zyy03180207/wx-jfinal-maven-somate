package com.program.somate.selector.cache.entity;

/**
 * 缓存实体类
 * @author yangyang.zhang
 * @Package com.program.somate.selector.cache.entity 
 * @Date 2017年9月27日 上午10:51:46 
 * @Description TODO(用一句话描述该文件做什么)
 * @version V1.0
 */
public class BaseEntity {

	public String fromUser;
	public String nickName;
	
	public String getFromUser() {
		return fromUser;
	}
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	
}
