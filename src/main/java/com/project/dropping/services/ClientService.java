package com.project.dropping.services;

import com.project.dropping.model.Client;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface ClientService {

    byte bringingTheDatabaseIntoValidForm(Client eachClient);

    Client findById(Long id);

    UserDetailsService userDetailsService();

    List<Client> findAll();

    public String hashSha256(String password);
    public String hashMD5(String input);

    Client findByLogin(String buyerLogin);

    boolean existsByUserLogin(String buyerLogin);

    void save(Client client);

    boolean existByBuyerLoginAndEmail(String buyerLogin,String buyerEmail);
}
