package com.terwergreen.plugins.auth;

import com.terwergreen.plugins.BugucmsPlugin;
import org.pf4j.PluginException;
import org.pf4j.PluginWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Terwer
 * @Date 2018/11/27 16:03
 * @Version 1.0
 * @Description 授权插件
 **/
public class AuthPlugin extends BugucmsPlugin {
    private static final Logger logger = LoggerFactory.getLogger(AuthPlugin.class);

    public AuthPlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    public void start() throws PluginException {
        super.start();
        logger.info("AuthPlugin started in " + getApplicationContext());
    }

    @Override
    public void stop() {
        super.stop();
        logger.info("AuthPlugin stoped");
    }
}
