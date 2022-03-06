package com.muto.preG.token;

import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Service
public class CookieService {
    public Cookie createCookie(String cookieName, String value) {
        Cookie token = new Cookie(cookieName, value);
        token.setHttpOnly(true);
        if (cookieName.equals(TokenService.ACCESS_TOKEN_NAME)) {
            token.setMaxAge((int)TokenService.accessTokenValidTime);
        }else{
            token.setMaxAge((int)TokenService.refreshTokenValidTime);
        }
        token.setPath("/");
        return token;
    }

    public Cookie getCookie(HttpServletRequest req, String cookieName){
        final Cookie[] cookies = req.getCookies();
        if(cookies==null) return null;
        for(Cookie cookie : cookies){
            if(cookie.getName().equals(cookieName))
                return cookie;
        }
        return null;
    }
}
