package com.project.dropping.repository;

import com.project.dropping.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByClientLogin(String clientLogin);


    Optional<Client> findByClientName(String clientName);

    boolean existsByClientLoginAndClientEmail(String clientLogin, String clientEmail);

    @Query("select (count(c) > 0) from Client c where c.clientLogin = ?1")
    boolean existsByClientLogin(String clientLogin);
}