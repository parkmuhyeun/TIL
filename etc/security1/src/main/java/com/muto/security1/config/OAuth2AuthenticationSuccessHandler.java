package com.muto.security1.config;

import com.muto.security1.config.auth.PrincipalDetails;
import com.muto.security1.config.token.CookieUtil;
import com.muto.security1.config.token.JwtTokenProvider;
import com.muto.security1.config.token.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JwtTokenProvider jwtTokenProvider;
    private final CookieUtil cookieUtil;
    private final RedisUtil redisUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        System.out.println("로그인 후 jwt 넣어야 할 곳");
        PrincipalDetails userDetails = (PrincipalDetails) authentication.getPrincipal();

        final String token = jwtTokenProvider.createAccessToken(userDetails.getUser().getUsername(), userDetails.getUser().getRole());
        final String refreshJwt = jwtTokenProvider.createRefreshToken(userDetails.getUser().getUsername(), userDetails.getUser().getRole());
        Cookie accessToken = cookieUtil.createCookie(JwtTokenProvider.ACCESS_TOKEN_NAME, token);
        Cookie refreshToken = cookieUtil.createCookie(JwtTokenProvider.REFRESH_TOKEN_NAME, refreshJwt);
        redisUtil.setDataExpire(refreshJwt, userDetails.getUser().getUsername(), JwtTokenProvider.refreshTokenValidTime);
        response.addCookie(accessToken);
        response.addCookie(refreshToken);
    }
}
