package com.project.dropping.services;

import com.project.dropping.model.Client;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    byte bringingTheDatabaseIntoValidForm(Client eachClient);

    Client findById(Long id);

    UserDetailsService userDetailsService();

    List<Client> findAll();

    public String hashSha256(String password);
    public String hashMD5(String input);

    Client findByLogin(String clientLogin);

    Optional<Client> findByClientName(String clientName);

    boolean existsByClientLogin(String clientLogin);

    String save(Client client);
}
