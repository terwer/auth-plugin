package com.terwergreen.plugins.auth.front;

import com.terwergreen.plugins.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Terwer
 * @Date 2018/11/29 1:23
 * @Version 1.0
 * @Description 控制器
 **/
@Controller
@RequestMapping("auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @RequestMapping(value = "login", produces = {"text/plain;charset=utf-8"})
    public String auth(Model model) {
        String systemInfo = authService.getSystemInfo();
        model.addAttribute("systemInfo", systemInfo);
        return "login";
    }
}
