package com.okta.springsecurityauth;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

    @RequestMapping("/")
    @ResponseBody
    public String home(@AuthenticationPrincipal OAuth2User oauth2User) {
        return "Welcome, " + oauth2User.getName();
    }

    @RequestMapping("/attributes")
    @ResponseBody
    public String attributes(@AuthenticationPrincipal OAuth2User oauth2User) {
        return oauth2User.getAttributes().toString();
    }

    @RequestMapping("/authorities")
    @ResponseBody
    public String authorities(@AuthenticationPrincipal OAuth2User oauth2User) {
        return oauth2User.getAuthorities().toString();
    }
    
}