package com.muto.security1.config.token;

import com.muto.security1.config.auth.PrincipalDetails;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@Component
public class JwtAuthenticationFilter extends GenericFilterBean {

    private final JwtTokenProvider jwtTokenProvider;
    private final CookieUtil cookieUtil;
    private final RedisUtil redisUtil;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Cookie jwtToken = cookieUtil.getCookie((HttpServletRequest) request, JwtTokenProvider.ACCESS_TOKEN_NAME);
        System.out.println("ㅇㅁㄴㅇㄴㅁㅇㅁㅇㅁㅇㅁㄴㅇㄴㅁㅇㅁㅇㄴㄴㅇㅁㄴㅁ");
        String username = null;
        String jwt = null;
        String refreshJwt = null;
        String refreshUname = null;

        try {
            if (jwtToken != null) {
                System.out.println("getvalue 값 ---:" + jwtToken.getValue());
                jwt = jwtToken.getValue();
                username = jwtTokenProvider.getUserPk(jwt);
            }
            //accesstoken 유효한경우
            if (jwtTokenProvider.validateToken(jwt)) {
                Authentication authentication = jwtTokenProvider.getAuthentication(jwt);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (ExpiredJwtException e) {
            //Access token이 유효하지 않은 경우 refresh token을 읽음
            Cookie refreshToken = cookieUtil.getCookie((HttpServletRequest) request, jwtTokenProvider.REFRESH_TOKEN_NAME);
            if (refreshToken != null) {
                refreshJwt = refreshToken.getValue();
            }
        } catch (Exception e) {
        }

        try {
            //refresh token 유효한 경우 access token 재생성하고 요청 허가
            if (refreshJwt != null) {
                refreshUname = redisUtil.getData(refreshJwt);

                Authentication authentication = jwtTokenProvider.getAuthentication(refreshJwt);
                SecurityContextHolder.getContext().setAuthentication(authentication);

                PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
                String newToken = jwtTokenProvider.createAccessToken(refreshUname, principal.getUser().getRole());

                Cookie newAccessToken = cookieUtil.createCookie(JwtTokenProvider.ACCESS_TOKEN_NAME, newToken);
                ((HttpServletResponse) response).addCookie(newAccessToken);
            }
        } catch (ExpiredJwtException e) {
        }

        chain.doFilter(request, response);
    }
}