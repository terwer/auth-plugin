package com.terwergreen.plugins.auth.front;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制器
 *
 * @author Terwer
 * @version 1.0 2018/11/29 1:23
 **/
@Controller
@RequestMapping("auth")
public class AuthController {
	@RequestMapping(value = "login", produces = { "text/plain;charset=utf-8" })
	public String auth(Model model, HttpServletRequest request) {
		return "auth/login";
	}
}
