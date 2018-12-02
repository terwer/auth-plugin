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
 * @Author Terwer
 * @Date 2018/11/27 16:03
 * @Version 1.0
 * @Description 扩展点
 **/
@Extension
public class AuthPluginExtension implements PluginInterface {
    private static final Logger logger = LoggerFactory.getLogger(AuthPluginExtension.class);
    private GenericApplicationContext applicationContext;

    @Autowired
    private AuthApi authApi;

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
        logger.info("AuthPluginExtension registerBean " + AuthController.class + " in applicationContext " + applicationContext);
        applicationContext.registerBean(AuthApi.class);
        logger.info("AuthPluginExtension registerBean " + AuthApi.class + " in applicationContext " + applicationContext);
        applicationContext.registerBean(AuthServiceImpl.class);
        logger.info("AuthPluginExtension registerBean " + AuthServiceImpl.class + " in applicationContext " + applicationContext);
    }

    @Override
    public String identify() {
        return "AuthPlugin identify in plugin,theme is:" + commonService.getSiteConfig("webtheme");
    }

    @Override
    public List<?> reactiveRoutes() {
        return new ArrayList<RouterFunction<?>>() {{
            add(authApi.coreApi());
            add(authApi.coreInfoApi());
        }};
    }

    @Override
    public Map data() {
        Map dataMap = new HashMap();
        dataMap.put("securityOn", 1);
        dataMap.put("loginPath", "login");
        // 查询后台地址
        String adminPath = (String) commonService.getSiteConfig("adminPath");
        dataMap.put("adminPath", adminPath);
        return dataMap;
    }
}
