package com.project.dropping.services;

import com.project.dropping.model.Seller;


public interface SellerService {

    Seller findSellerByName(String sellerName);

    void saveSeller(Seller seller);
}
