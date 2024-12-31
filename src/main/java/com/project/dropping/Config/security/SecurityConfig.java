package com.project.dropping.config.security;

import com.project.dropping.config.cookie.CustomAuthenticationSuccessHandler;
import com.project.dropping.config.filters.JwtAuthenticationFilter;
import com.project.dropping.config.security.securitycontext.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.http.SessionCreationPolicy.ALWAYS;

/**
 *
 * Класс отвечающий за безопасность приложения
 *
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Bean //возвращаем кастомный MyUserDetailsService
    public UserDetailsService userDetailsService() {
        return new MyUserDetailsService();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean //создание SecurityFilterChain это цепочка способов проверки запроса
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .requestMatchers("/main/**").permitAll()//вход без авторизации
                        .requestMatchers("/companyName").authenticated()
                        .requestMatchers("/client/**").authenticated()
                        .requestMatchers("/product/**").permitAll()
                        .requestMatchers("/").hasRole("USER")
                        .requestMatchers("/c/l").hasRole("SELLER")
                        .requestMatchers("/seller/add").hasRole("ADMIN")
                        .requestMatchers("seller/**").permitAll()
                        .anyRequest().permitAll())
                .formLogin((form) -> form
                        .permitAll()
                        .loginPage("/main/login")
                        .successHandler(customAuthenticationSuccessHandler) // Указываем кастомный обработчик
                        .usernameParameter("username")
                        .passwordParameter("password"))
                .sessionManagement(manager -> manager.sessionCreationPolicy(ALWAYS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(LogoutConfigurer -> LogoutConfigurer
                        .permitAll()
                        .logoutUrl("/main/logout")
                        .deleteCookies("token")
                        .clearAuthentication(true)
                        .invalidateHttpSession(true))
                .build();
    }


    @Bean //кодирование пароля
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(5);
    }


    @Bean // метод который проводит аунтефикацию пользователя
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
            throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean // используется для удаления префикса "HAS-" при проверке роли
    GrantedAuthorityDefaults grantedAuthorityDefaults() {
        return new GrantedAuthorityDefaults("");
    }
}
