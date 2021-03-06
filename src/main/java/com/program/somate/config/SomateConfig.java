package com.program.somate.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import com.jfinal.weixin.sdk.api.ApiConfigKit;
import com.jfinal.weixin.sdk.encrypt.WXBizMsgCrypt;
import com.program.somate.controller.SomateIndexController;
import com.program.somate.controller.SomateApiController;
import com.program.somate.controller.SomateMsgController;
import com.program.somate.controller.SomatePayController;
import com.program.somate.model.Fans;
import com.program.somate.model.NowFunction;
import com.program.somate.model.SingleChat;
import com.program.somate.model.WxConfig;
import com.program.somate.model.WxOrder;

public class SomateConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		// TODO Auto-generated method stub
		PropKit.use("a_little_config.txt");
		me.setViewType(ViewType.JSP);
		me.setDevMode(PropKit.getBoolean("devMode"));
		ApiConfigKit.setDevMode(PropKit.getBoolean("devMode"));
	}

	@Override
	public void configRoute(Routes me) {
		// TODO Auto-generated method stub
		me.add("/msg", SomateMsgController.class);
		me.add("/api", SomateApiController.class, "/pages");
		me.add("/pay", SomatePayController.class, "/pages");
		me.add("/somate", SomateIndexController.class, "/pages");
	}

	public static C3p0Plugin createDruidPlugin() {
		String jdbcUrl = new String(PropKit.get("jdbcUrl"));
		String driver = PropKit.get("driverClass");
		String username = new String(PropKit.get("username"));
		String password = new String(PropKit.get("password"));
		return new C3p0Plugin(jdbcUrl, username, password, driver);
	}

	@Override
	public void configPlugin(Plugins me) {
		// TODO Auto-generated method stub
		C3p0Plugin plugin = createDruidPlugin();
		me.add(plugin);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(plugin);
		arp.setShowSql(true);
		arp.setDialect(new MysqlDialect());
		me.add(arp);
		arp.addMapping("tb_fans", "cid", Fans.class);
		arp.addMapping("tb_wx_config", "id", WxConfig.class);
		arp.addMapping("tb_now_function", "id", NowFunction.class);
		arp.addMapping("tb_single_chat", "id", SingleChat.class);
		arp.addMapping("tb_wx_order", "id", WxOrder.class);
	}

	@Override
	public void configEngine(Engine me) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterJFinalStart() {
		// TODO Auto-generated method stub
		super.afterJFinalStart();
	}

	@Override
	public void beforeJFinalStop() {
		// TODO Auto-generated method stub
		super.beforeJFinalStop();
	}
}
