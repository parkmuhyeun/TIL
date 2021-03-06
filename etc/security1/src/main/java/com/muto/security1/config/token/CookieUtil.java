package com.muto.security1.config.token;

import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Service
public class CookieUtil {
    public Cookie createCookie(String cookieName, String value){
        Cookie token = new Cookie(cookieName,value);
        token.setHttpOnly(true);
        if (cookieName.equals(JwtTokenProvider.ACCESS_TOKEN_NAME)) {
            token.setMaxAge((int)JwtTokenProvider.accessTokenValidTime);
        }else{
            token.setMaxAge((int)JwtTokenProvider.refreshTokenValidTime);
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
