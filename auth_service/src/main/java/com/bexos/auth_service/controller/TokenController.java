package com.bexos.auth_service.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TokenController {
    @GetMapping
    public String getToken(@AuthenticationPrincipal OidcUser user) {
        System.out.println(user.getClaims());
        System.out.println(user.getUserInfo());
        System.out.println(user.getAuthorities());
        System.out.println(user.getName());
        System.out.println(user.getAttributes());
        OidcIdToken idToken = user.getIdToken();
        return idToken.getTokenValue();
    }
}
