package com.project.dropping.repository;

import com.project.dropping.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {

    @Transactional
    Seller findBySellerNameIgnoreCase(@NonNull String sellerName);

    @Transactional
    boolean existsBySellerId(String sellerId);
}