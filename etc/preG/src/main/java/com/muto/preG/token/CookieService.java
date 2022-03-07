package com.muto.preG.token;

import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Service
public class CookieService {
    public Cookie createCookie(String cookieName, String value) {

        long accessCookieValidTime = 30 * 60 + (30 * 60 * 2 * 9); //30분 + (utc + 9)
        long refreshCookieValidTime = 30 * 60 * 2 * 24 * 7 + (30 * 60 * 2 * 9); //일주일 + (utc + 9)

        Cookie token = new Cookie(cookieName, value);
        token.setHttpOnly(true);
        if (cookieName.equals(TokenService.ACCESS_TOKEN_NAME)) {
            token.setMaxAge((int)accessCookieValidTime);
        }else{
            token.setMaxAge((int)refreshCookieValidTime);
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
