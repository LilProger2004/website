package com.project.dropping.repository;

import com.project.dropping.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {
    Buyer findByBuyerLogin(String buyerLogin);

    @Query("select (count(b) > 0) from Buyer b where b.buyerLogin = ?1")
    boolean existsByBuyerLogin(String buyerLogin);
}