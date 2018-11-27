package com.terwergreen.plugins;

import org.pf4j.Extension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.reactive.function.server.RouterFunction;

import java.util.ArrayList;
import java.util.List;

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

    private void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        logger.info("AuthPlugin registerBean,applicationContext is:" + applicationContext);
    }

    @Override
    public String identify() {
        return "AuthPlugin identify in plugin";
    }

    @Override
    public List<?> reactiveRoutes() {
        return new ArrayList<RouterFunction<?>>() {{
        }};
    }
}
