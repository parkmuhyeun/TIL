package com.muto.preG.token;

import com.muto.preG.account.PrincipalDetails;
import com.muto.preG.config.AES256;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
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
        long decryptedId = 0;

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
                    decryptedId = Long.parseLong(aes256.decrypt(encodedId));
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
                Authentication authentication = tokenService.getAuthentication(refreshJwt);
                SecurityContextHolder.getContext().setAuthentication(authentication);

                PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
                String newToken = tokenService.createAccessToken(principal.getAccount().getUsername(), "ROLE_USER");
                String newRefreshToken = tokenService.createRefreshToken(principal.getAccount().getUsername(), "ROLE_USER");

                tokenRepository.deleteById(decryptedId);
                RefreshToken refreshToken = RefreshToken.builder()
                        .token(refreshJwt)
                        .build();
                Long refreshTokenId = tokenRepository.save(refreshToken).getId();
                String encodedTokenId = aes256.encrypt(refreshTokenId.toString());

                Cookie newAccessCookie = cookieService.createCookie(TokenService.ACCESS_TOKEN_NAME, newToken);
                Cookie newRefreshCookie = cookieService.createCookie(TokenService.REFRESH_TOKEN_NAME, encodedTokenId);

                ((HttpServletResponse) response).addCookie(newAccessCookie);
                ((HttpServletResponse) response).addCookie(newRefreshCookie);
//                TODO logout
//                로그아웃할때 삭제 (refresh db에서 user나 index로 찾아서 제거하고, access, refresh cookie도 제거)
            }
        } catch (Exception e) {
        }

        chain.doFilter(request, response);
    }
}
