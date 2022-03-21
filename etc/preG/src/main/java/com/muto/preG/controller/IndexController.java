package com.muto.preG.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Value("${app.cors.oauth2.authorizedRedirectUris}")
    private String home;

    @GetMapping("/")
    public String home() {
        return "ok";
    }

}
