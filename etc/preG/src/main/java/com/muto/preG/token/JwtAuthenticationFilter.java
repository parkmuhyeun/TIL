package com.muto.preG.token;

import com.muto.preG.account.PrincipalDetails;
import com.muto.preG.config.AES256;
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
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilterBean {

    private final AES256 aes256;
    private final CookieService cookieService;
    private final TokenService tokenService;
    private final TokenRepository tokenRepository;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        final Cookie jwtToken = cookieService.getCookie((HttpServletRequest) request, TokenService.ACCESS_TOKEN_NAME);
        String jwt = null;
        String refreshJwt = null;
        String encodedId = null;

        try {
            if (jwtToken != null) {
                jwt = jwtToken.getValue();
            }

            //accessToken 유효한경우
            if (tokenService.validateToken(jwt)) {
                Authentication authentication = tokenService.getAuthentication(jwt);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                //accessToken 유효하지 않은 경우 refresh token을 읽음
                Cookie refreshToken = cookieService.getCookie((HttpServletRequest) request, TokenService.REFRESH_TOKEN_NAME);
                if (refreshToken != null) {
                    encodedId = refreshToken.getValue();
                    long decryptedId = Long.parseLong(aes256.decrypt(encodedId));
                    RefreshToken token = tokenRepository.findById(decryptedId).orElseThrow();
                    // refresh 토큰이 유효하다면
                    if (tokenService.validateToken(token.getToken())) {
                        refreshJwt = token.getToken();
                    }
                }
            }
        }catch (Exception e) {
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
