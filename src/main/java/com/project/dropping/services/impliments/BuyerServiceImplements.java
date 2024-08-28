package com.project.dropping.services.impliments;

import com.project.dropping.model.Buyer;
import com.project.dropping.repository.BuyerRepository;
import com.project.dropping.services.BuyerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BuyerServiceImplements implements BuyerService {

    final BuyerRepository buyerRepository;

    @Override
    public byte bringingTheDatabaseIntoValidForm(Buyer eachBuyer) {
        byte changeCode = 0;
        if (eachBuyer.getBuyerEmail() == null || eachBuyer.getBuyerEmail().isEmpty()) {
            eachBuyer.setBuyerEmail("Default");
            buyerRepository.save(eachBuyer);
            changeCode++;
        }
        if (eachBuyer.getBuyerLogin() == null || eachBuyer.getBuyerLogin().isEmpty()) {
            eachBuyer.setBuyerLogin("Default");
            buyerRepository.save(eachBuyer);
            changeCode++;
        }
        if (eachBuyer.getBuyerName() == null || eachBuyer.getBuyerName().isEmpty()) {
            eachBuyer.setBuyerName("Default");
            buyerRepository.save(eachBuyer);
            changeCode++;
        }
        if (eachBuyer.getBuyerPassword() == null || eachBuyer.getBuyerPassword().isEmpty()) {
            eachBuyer.setBuyerPassword("Default");
            buyerRepository.save(eachBuyer);
            changeCode++;
        }
        return changeCode;
    }

    @Override
    public Buyer findById(Long id) {
        return buyerRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Buyer> findAll() {
        return buyerRepository.findAll();
    }

    @Override
    public String hashSha256(String password) {
        try {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            String salt = "some_random_salt";
            String passWithSalt = password + salt;
            byte[] passBytes = passWithSalt.getBytes();
            byte[] passHash = sha256.digest(passBytes);
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< passHash.length ;i++) {
                sb.append(Integer.toString((passHash[i] & 0xff) + 0x100, 16).substring(1));
            }
            String generatedPassword = sb.toString();
            return generatedPassword;
        } catch (NoSuchAlgorithmException e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public String hashMD5(String input) {
        try {

            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] messageDigest = md.digest(input.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);

            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Buyer findByLogin(String buyerLogin) {

        return buyerRepository.findByBuyerLogin(buyerLogin);
    }

    @Override
    public boolean existsByUserLogin(String buyerLogin) {
        return buyerRepository.existsByBuyerLogin(buyerLogin);
    }
}
