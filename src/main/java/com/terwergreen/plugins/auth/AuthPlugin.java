package com.terwergreen.plugins.auth;

import com.terwergreen.plugins.BugucmsPlugin;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.pf4j.PluginException;
import org.pf4j.PluginWrapper;

/**
 * @Author Terwer
 * @Date 2018/11/27 16:03
 * @Version 1.0
 * @Description 授权插件
 **/
public class AuthPlugin extends BugucmsPlugin {
    private static final Log logger = LogFactory.getLog(AuthPlugin.class);

    public AuthPlugin(PluginWrapper wrapper) {
        super(wrapper);
        logger.info("AuthPlugin contructor");
    }

    @Override
    public void start() throws PluginException {
        super.start();
        logger.info("AuthPlugin started");
    }

    @Override
    public void stop() {
        super.stop();
        logger.info("AuthPlugin stoped");
    }
}
