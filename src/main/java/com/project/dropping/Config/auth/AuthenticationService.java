package com.project.dropping.config.auth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.dropping.config.jwt.JwtService;
import com.project.dropping.config.security.securitycontext.MyUserDetailsService;
import com.project.dropping.model.Client;
import com.project.dropping.services.ClientService;
import com.project.dropping.services.RoleService;
import com.project.dropping.utils.FormatParser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final ClientService clientService;
    private final JwtService jwtService;
    private final RoleService roleService;
    private final AuthenticationManager authenticationManager;
    private final MyUserDetailsService myUserDetailsService;

    //Регистрация пользователя
    public String signUp(Client client) {
        /*Client client;
        try {
            client = new ObjectMapper().readValue(client, Client.class);
            client.setClientRole(roleService.getUserRole());
            client.setClientId(UUID.randomUUID().toString());
            client.setClientPassword(new BCryptPasswordEncoder().encode(client.getPassword()));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }*/
        clientService.save(client);

        var jwt = jwtService.generateToken(myUserDetailsService.loadUserByUsername(client.getUsername()));
        return jwt;
    }

    //Аутентификация пользователя
    public String signIn(String request) {
        Client client;
        try {
            client = new ObjectMapper().readValue(FormatParser.urlEncodedToJson(request), Client.class);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                client.getUsername(),
                client.getPassword()
        ));

        var jwt = jwtService.generateToken(myUserDetailsService.loadUserByUsername(client.getUsername()));
        return jwt;
    }
}
