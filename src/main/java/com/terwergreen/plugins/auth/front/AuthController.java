package com.terwergreen.plugins.auth.front;

import com.terwergreen.plugins.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(produces = {"text/plain;charset=utf-8"})
    @ResponseBody
    public String auth() {
        return "Hello World!";
    }

    @RequestMapping(value = "info", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> info() {
        ResponseEntity<String> responseEntity = null;
        responseEntity = ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body("Hello World");
        try {
            String systemInfo = authService.getSystemInfo();
            responseEntity = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(systemInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
    }
}
