package com.exam.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityFilterChainConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    
        // 커스터마이징 처리

        // 1. 불필요한 인증제거
        http.authorizeRequests().antMatchers("/login", "/home","/signup", "/webjars/**", "/images/**").permitAll().anyRequest().authenticated();

        // 2. 로그인 관련 작업
        // formLogin() -> 사용자가 만든 로그인 화면으로 인증처리
        // loginPage() -> 로그인 페이지로 갈 수 있는 요청맵핑값 <a href="login"...
        // loginProcessingUrl() -> 폼의 Action값           <form action="auth"...
        // usernameParameter() -> input name의 name값      <input type=...name="userid"...
        // passwordParameter() -> input password의 name값  <input type=...name="passwd"...
        // failureForwardUrl() -> 로그인 실패시 리다이렉트되는 요청맵핑값
        // successForwardUrl() -> 로그인 성공시 리다이렉트되는 요청맵핑값
        // defaultSuccessUrl() -> 로그인 성공시 리다이렉트되는 요청맵핑값
        http.csrf().disable();
        http.formLogin()
        .loginPage("/login")
        .loginProcessingUrl("/auth").usernameParameter("userid")
        .passwordParameter("passwd").failureForwardUrl("/login_fail")
//        .successForwardUrl("/login_success")
        .defaultSuccessUrl("/login_success", true);

        // 3. csrf 비활성화


        // 4. 로그아웃 관련작업
        // logoutUrl() -> security가 자동으로 로그아웃 처리해주는 요청맵핑갑
        // logoutSuccessUrl() -> logout 성공시 리다이렉트 되는 요청맵핑값
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/home");

        return http.build();
    }

}
