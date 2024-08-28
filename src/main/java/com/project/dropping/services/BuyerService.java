package com.project.dropping.services;

import com.project.dropping.model.Buyer;

import java.util.List;

public interface BuyerService {

    byte bringingTheDatabaseIntoValidForm(Buyer eachBuyer);

    Buyer findById(Long id);

    List<Buyer> findAll();

    public String hashSha256(String password);
    public String hashMD5(String input);

    Buyer findByLogin(String buyerLogin);

    boolean existsByUserLogin(String buyerLogin);
}
