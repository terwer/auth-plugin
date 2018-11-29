package com.terwergreen.plugins.auth;

import com.terwergreen.core.CommonService;
import com.terwergreen.plugins.PluginInterface;
import com.terwergreen.plugins.auth.config.WebFluxSecurityConfig;
import org.pf4j.Extension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.reactive.function.server.RouterFunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Terwer
 * @Date 2018/11/27 16:05
 * @Version 1.0
 * @Description 扩展点
 **/
@Extension
public class AuthPluginExtension implements PluginInterface {
    private static final Logger logger = LoggerFactory.getLogger(AuthPluginExtension.class);
    private ApplicationContext applicationContext;

    @Autowired
    private CommonService commonService;

    private void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        // AnnotationConfigReactiveWebServerApplicationContext container = (AnnotationConfigReactiveWebServerApplicationContext) applicationContext;
        // logger.debug("AuthPlugin registerBean in container,applicationContext is:" + container);
        // container.registerBean(Object.class);
        // logger.info("AuthPlugin registerBean " + Object.class + " in container " + container);
    }

    @Override
    public String identify() {
        return "AuthPlugin";
    }

    @Override
    public List<?> reactiveRoutes() {
        return new ArrayList<RouterFunction<?>>() {{
        }};
    }

    @Override
    public Map data() {
        Map dataMap = new HashMap();
        dataMap.put("securityOn", WebFluxSecurityConfig.SECURITY_ON);
        dataMap.put("loginPath", WebFluxSecurityConfig.LOGIN_PATH);
        // 查询后台地址
        String adminPath = (String) commonService.getSiteConfig("adminPath");
        dataMap.put("adminPath", adminPath);
        return dataMap;
    }
}
