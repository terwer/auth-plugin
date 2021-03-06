package com.terwergreen.plugins.auth;

import com.terwergreen.core.CommonService;
import com.terwergreen.plugins.PluginInterface;
import com.terwergreen.plugins.auth.front.AuthApi;
import com.terwergreen.plugins.auth.front.AuthController;
import com.terwergreen.plugins.auth.service.impl.AuthServiceImpl;
import org.pf4j.Extension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.web.reactive.function.server.RouterFunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 扩展点
 *
 * @author Terwer
 * @version 1.0 2018/11/27 16:03
 **/
@SuppressWarnings("all")
@Extension
public class AuthPluginExtension implements PluginInterface {
	private static final Logger logger = LoggerFactory.getLogger(AuthPluginExtension.class);
	private GenericApplicationContext applicationContext;

	@Autowired
	private CommonService commonService;

	public AuthPluginExtension(GenericApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
		logger.info("AuthPluginExtension contructor");
		// 注册插件依赖
		registerBeans();
	}

	private void registerBeans() {
		applicationContext.registerBean(AuthController.class);
		logger.info("AuthPluginExtension registerBean " + AuthController.class + " in applicationContext "
				+ applicationContext);
		applicationContext.registerBean(AuthApi.class);
		logger.info(
				"AuthPluginExtension registerBean " + AuthApi.class + " in applicationContext " + applicationContext);
		applicationContext.registerBean(AuthServiceImpl.class);
		logger.info("AuthPluginExtension registerBean " + AuthServiceImpl.class + " in applicationContext "
				+ applicationContext);
	}

	@Override
	public String identify() {
		return "AuthPlugin identify in plugin";
	}

	@Override
	public List<?> reactiveRoutes() {
		return new ArrayList<RouterFunction<?>>() {
			{
			}
		};
	}

	@Override
	public Map data() {
		Map dataMap = new HashMap();
		dataMap.put("securityOn", 1);
		dataMap.put("loginPath", "auth/login");
		dataMap.put("loginProcessingUrl", "api/auth/login");
		dataMap.put("logoutUrl", "auth/logout");
		dataMap.put("usernameParameter", "username");
		dataMap.put("passwordParameter", "password");
		// 查询后台地址
		String adminPath = (String) commonService.getSiteConfigItem("adminPath");
		dataMap.put("adminPath", adminPath);
		return dataMap;
	}
}
