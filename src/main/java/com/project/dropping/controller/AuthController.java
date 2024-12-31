package com.project.dropping.controller;


import com.project.dropping.config.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    final AuthenticationService authenticationService;


    /*@PostMapping("/jwt-cookie")
    public String SingIn(@RequestBody String loginAndPassword, HttpServletResponse response) {
        CookieService.addCookie(response,"token",authenticationService.signIn(loginAndPassword),7 * 24 * 60 * 60);
        return "redirect:/main/";
    }*/
}
