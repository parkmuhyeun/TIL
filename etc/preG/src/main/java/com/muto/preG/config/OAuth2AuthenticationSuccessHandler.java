package com.muto.preG.config;

import com.muto.preG.account.PrincipalDetails;
import com.muto.preG.token.CookieService;
import com.muto.preG.token.RefreshToken;
import com.muto.preG.token.TokenRepository;
import com.muto.preG.token.TokenService;
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

    private final AES256 aes256;
    private final TokenRepository tokenRepository;
    private final TokenService tokenService;
    private final CookieService cookieService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        PrincipalDetails userDetails = (PrincipalDetails) authentication.getPrincipal();

        final String token = tokenService.createAccessToken(userDetails.getAccount().getUsername(), "ROLE_USER");
        final String refreshJwt = tokenService.createRefreshToken(userDetails.getAccount().getUsername(), "ROLE_USER");
        //refresh token 저장후 index를 해시화 해서 cookie에 추가
        RefreshToken refreshToken = RefreshToken.builder()
                .token(refreshJwt)
                .build();
        Long refreshTokenId = tokenRepository.save(refreshToken).getId();

        try {
            String encodedId = aes256.encrypt(refreshTokenId.toString());
            Cookie accessToken = cookieService.createCookie(TokenService.ACCESS_TOKEN_NAME, token);
            Cookie encodedIdToken = cookieService.createCookie(TokenService.REFRESH_TOKEN_NAME, encodedId);
            response.addCookie(accessToken);
            response.addCookie(encodedIdToken);
        } catch (Exception e) {
        }
    }
}
