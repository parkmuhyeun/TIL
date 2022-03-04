package com.muto.preG.config;

import com.muto.preG.config.oauth.PrincipalOauth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PrincipalOauth2UserService principalOauth2UserService;
    private final OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
         http.csrf().disable()
                 .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

         http.oauth2Login()
                .userInfoEndpoint()
                 .userService(principalOauth2UserService)
                 .and()
                 .successHandler(oAuth2AuthenticationSuccessHandler)
                 .and()
                 .logout()
                 .logoutSuccessUrl("/");
    }
}
