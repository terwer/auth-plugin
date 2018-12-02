package com.terwergreen.plugins.auth.front;

import com.terwergreen.core.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @Author Terwer
 * @Date 2018/11/23 15:02
 * @Version 1.0
 * @Description webFlux Api
 **/
@Component
public class AuthApi {

    @Autowired
    private CommonService commonService;

    public RouterFunction<?> coreApi() {
        return route(GET("/api/hello"), req -> ServerResponse.ok().body(Mono.just("core api in plugin:systemInfo" + commonService.getSiteConfig("webname")), String.class));
    }

    public RouterFunction<?> coreInfoApi() {
        return route(GET("/api/hello/info"), req -> ServerResponse.ok().body(Mono.just("core api info in plugin"), String.class));
    }
}

