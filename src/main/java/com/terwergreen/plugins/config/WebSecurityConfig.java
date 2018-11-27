package com.terwergreen.plugins.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author Terwer
 * @Date 2018/6/22 15:55
 * @Version 1.0
 * @Description 安全配置
 **/
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private Log logger = LogFactory.getLog(this.getClass());
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    /**
//     * 密码加密策略
//     * @return
//     */
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //运行加载iframe
//        http.headers().frameOptions().disable();
//
//        //关闭csrf
//        http.csrf().disable();
//
//        // 获取站点配置
//        // SiteConfigDTO siteConfigDTO = commonService.getSiteConfig();
//
//        //配置权限及登录验证
//        http
//                .authorizeRequests()
//                //.antMatchers("/").permitAll()
//                //.antMatchers(API_DOC_BASE_PATH).permitAll()
//                //.antMatchers(SERVLET_BASE_PATH).permitAll()
//                //.antMatchers(XMLRPC_URL).permitAll()
//                //.antMatchers("/" + siteConfigDTO.getAdminpath() + "/**").hasRole("ADMIN")
//                .and()
//                .formLogin()
//                //.loginPage(AUTH_LOGIN_PAGE).failureUrl(AUTH_ERROR_URL)
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        //内存中缓存权限数据
//        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("123456")).roles("ADMIN");
//        // String encodePassword = BugucmsConfig.passwordEncoder().encode("123456");
//        // logger.info("source:123456,encodePassword:" + encodePassword);
//        // auth.userDetailsService(customUserService()).passwordEncoder(BugucmsConfig.passwordEncoder());
//    }
//}

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }

}