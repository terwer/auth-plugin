package com.terwergreen.plugins.auth;

import com.terwergreen.plugins.BugucmsPluginExtension;
import com.terwergreen.plugins.auth.config.WebFluxSecurityConfig;
import com.terwergreen.plugins.auth.front.AuthApi;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.pf4j.Extension;
import org.springframework.context.support.GenericApplicationContext;

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
public class AuthPluginExtension extends BugucmsPluginExtension {
    private static final Log logger = LogFactory.getLog(AuthPluginExtension.class);
    private GenericApplicationContext applicationContext;

    public AuthPluginExtension(GenericApplicationContext applicationContext) {
        super(applicationContext);
        this.applicationContext = applicationContext;
        logger.info("AuthPluginExtension contructor");
        // 注册插件依赖
        super.registerBean(AuthApi.class);
    }

    @Override
    public String identify() {
        return "AuthPlugin in " + getBugucmsApplicationContext();
    }

    @Override
    public List<?> reactiveRoutes() {
//        return new ArrayList<RouterFunction<?>>() {{
//        }};
        return null;
    }

    @Override
    public Map data() {
        Map dataMap = new HashMap();
        dataMap.put("securityOn", WebFluxSecurityConfig.SECURITY_ON);
        dataMap.put("loginPath", WebFluxSecurityConfig.LOGIN_PATH);
        // 查询后台地址
        // CommonService commonService = applicationContext.getBean(CommonService.class);
        String adminPath = "admin";//(String) commonService.getSiteConfig("adminPath");
        dataMap.put("adminPath", adminPath);
        return dataMap;
    }
}
