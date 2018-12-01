package com.terwergreen.plugins.auth.front;

import com.terwergreen.core.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author Terwer
 * @Date 2018/11/29 20:41
 * @Version 1.0
 * @Description 授权Api
 **/
@Controller
@RequestMapping("authApi")
public class AuthApi {

    @Autowired
    private CommonService commonService;

    @RequestMapping(value = "/info", method = RequestMethod.GET, produces = "text/plin;charset=utf-8")
    @ResponseBody
    public String info() {
        return "core api in plugin,SystemInfo:" + commonService.getSiteConfig("webname");
    }
}