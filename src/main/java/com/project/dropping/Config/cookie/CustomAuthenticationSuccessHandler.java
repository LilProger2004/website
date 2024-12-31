package com.project.dropping.config.cookie;

import com.project.dropping.config.jwt.JwtService;
import com.project.dropping.config.security.securitycontext.MyUserDetailsService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    final JwtService jwtService;
    final MyUserDetailsService myUserDetailsService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {

        String username = authentication.getName();
        //добавляем cookie
        response.addCookie(CookieService.addCookie(response,"token", jwtService.generateToken(myUserDetailsService.loadUserByUsername(username)), 7 * 24 * 60 * 60));
        // Перенаправление на защищённую страницу
        response.sendRedirect("/main/");
    }
}