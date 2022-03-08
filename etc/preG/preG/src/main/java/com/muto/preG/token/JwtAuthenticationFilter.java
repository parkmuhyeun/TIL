package com.muto.preG.token;

import com.muto.preG.account.PrincipalDetails;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
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

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilterBean {

    private final
    private final CookieService cookieService;
    private final TokenService tokenService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        final Cookie jwtToken = cookieService.getCookie((HttpServletRequest) request, TokenService.ACCESS_TOKEN_NAME);
        String jwt = null;
        String refreshJwt = null;

        try {
            if (jwtToken != null) {
                jwt = jwtToken.getValue();
            }

            //accessToken 유효한경우
            if (tokenService.validateToken(jwt)) {
                Authentication authentication = tokenService.getAuthentication(jwt);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (ExpiredJwtException e) {
            //accessToken 유효하지 않은 경우 refresh token을 읽음
            Cookie refreshToken = cookieService.getCookie((HttpServletRequest) request, TokenService.REFRESH_TOKEN_NAME);
            if (refreshToken != null) {
                refreshJwt = refreshToken.getValue();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        // refreshToken 유효한경우
        try {
            if (refreshJwt != null) {
                //TODO db와 비교해서 확인해야함
                Authentication authentication = tokenService.getAuthentication(refreshJwt);
                SecurityContextHolder.getContext().setAuthentication(authentication);

                PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
                String newToken = tokenService.createAccessToken(principal.getAccount().getUsername(), "ROLE_USER");

                Cookie newAccessToken = cookieService.createCookie(TokenService.ACCESS_TOKEN_NAME, newToken);
                ((HttpServletResponse) response).addCookie(newAccessToken);
                //TODO refreshToken도 재발급
            }
        } catch (ExpiredJwtException e) {
        }

        chain.doFilter(request, response);
    }
}
