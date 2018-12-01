package com.terwergreen.plugins.auth.front;

import com.terwergreen.core.CommonService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author Terwer
 * @Date 2018/11/29 5:17
 * @Version 1.0
 * @Description 控制器
 **/
@RequestMapping("auth")
public class AuthController {
    private static final Log logger = LogFactory.getLog(AuthController.class);

    @Autowired
    private CommonService commonService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public String login(Model model) {
        return "auth/login" + commonService.getSiteConfig("webname");
    }
}
