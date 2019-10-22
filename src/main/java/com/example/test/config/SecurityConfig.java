//package com.demo.config;
//
//import com.demo.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserService userService;
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // 设置登录页面
//        http.formLogin().loginPage("/login")
//        .and()
//        // 登录请求任何人可以访问
//        .authorizeRequests().antMatchers("/login").permitAll()
//        .antMatchers("/admin/**").hasRole("ADMIN") // 需要相应的角色才能访问
//        // 任何请求验证后可以访问
//        .anyRequest().authenticated()
//        .and()
//        .csrf().disable();          // 关闭csrf防护
//
//
//    }
//}