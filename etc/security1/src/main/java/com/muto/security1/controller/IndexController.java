package com.muto.security1.controller;

import com.muto.security1.config.auth.PrincipalDetails;
import com.muto.security1.config.oauth.PrincipalOauth2UserService;
import com.muto.security1.config.token.CookieUtil;
import com.muto.security1.config.token.JwtTokenProvider;
import com.muto.security1.config.token.RedisUtil;
import com.muto.security1.domain.User;
import com.muto.security1.repository.UserRepository;
import com.nimbusds.oauth2.sdk.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final CookieUtil cookieUtil;
    private final JwtTokenProvider jwtTokenProvider;
    private final RedisUtil redisUtil;
    private final PrincipalOauth2UserService principalOauth2UserService;
    private final AuthenticationManager authenticationManager;

    @ResponseBody
    @GetMapping("/test/login")
    public String testLogin(Authentication authentication,
                            @AuthenticationPrincipal PrincipalDetails userDetails) {
        System.out.println("/test/login ==========");
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        System.out.println("authentication: " + principalDetails.getUser());

        System.out.println("userDetails: " + userDetails.getUser());
        return "세션 정보 확인하기";
    }

    @ResponseBody
    @GetMapping("/test/oauth/login")
    public String testOAuthLogin(
            Authentication authentication,
            @AuthenticationPrincipal OAuth2User oauth) {
        System.out.println("/test/oauth/login ==========");
        OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();
        System.out.println("authentication: " + oauth2User.getAttributes());

        System.out.println("oauth2User: " + oauth.getAttributes());
        return "OAuth 세션 정보 확인하기";
    }


    @PostMapping("/login")
    public String login() {
        return "/";
    }

    @ResponseBody
    @PostMapping("/logoutpr")
    public String logoutpr() {
        return "redirect:/";
    }

    @GetMapping("/")
    public String index(){

        return "index";
    }

    @ResponseBody
    @GetMapping("/user")
    public String user(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        System.out.println("principalDetails:" +principalDetails);
        return "user";
    }

    @ResponseBody
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @ResponseBody
    @GetMapping("/manager")
    public String manager() {
        return "manager";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm";
    }

    @PostMapping("/join")
    public String join(User user) {
        System.out.println(user);
        user.setRole("ROLE_USER");
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);
        userRepository.save(user);
        return "redirect:/loginForm";
    }

    @ResponseBody
    @Secured("ROLE_ADMIN")
    @GetMapping("/info")
    public String info() {
        return "개인정보";
    }

    @ResponseBody
    @PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/data")
    public String data() {
        return "데이터정보";
    }


}