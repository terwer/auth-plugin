package com.terwergreen.plugins.auth.front;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author Terwer
 * @Date 2018/11/29 5:17
 * @Version 1.0
 * @Description 控制器
 **/
@RequestMapping("auth")
public class AuthController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "auth/login";
    }
}
