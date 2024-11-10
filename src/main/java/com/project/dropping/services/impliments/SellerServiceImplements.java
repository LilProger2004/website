package com.project.dropping.services.impliments;

import com.project.dropping.model.Seller;
import com.project.dropping.repository.SellerRepository;
import com.project.dropping.services.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SellerServiceImplements implements SellerService {

    final SellerRepository sellerRepository;

    @Override
    public Seller findSellerByName(String sellerName) {
        return sellerRepository.findBySellerNameIgnoreCase(sellerName);
    }

    @Override
    public void saveSeller(Seller seller) {
        sellerRepository.save(seller);
        sellerRepository.existsBySellerId(seller.getSellerId());
    }
}
