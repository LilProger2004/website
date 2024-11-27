package com.project.dropping.services.impliments;

import com.project.dropping.model.Client;
import com.project.dropping.repository.ClientRepository;
import com.project.dropping.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientServiceImplements implements ClientService {

    final ClientRepository clientRepository;

    @Override
    public byte bringingTheDatabaseIntoValidForm(Client eachClient) {
        byte changeCode = 0;
        if (eachClient.getClientEmail() == null || eachClient.getClientEmail().isEmpty()) {
            eachClient.setClientEmail("Default");
            clientRepository.save(eachClient);
            changeCode++;
        }
        if (eachClient.getClientLogin() == null || eachClient.getClientLogin().isEmpty()) {
            eachClient.setClientLogin("Default");
            clientRepository.save(eachClient);
            changeCode++;
        }
        if (eachClient.getUsername() == null || eachClient.getUsername().isEmpty()) {
            eachClient.setClientName("Default");
            clientRepository.save(eachClient);
            changeCode++;
        }
        if (eachClient.getClientPassword() == null || eachClient.getClientPassword().isEmpty()) {
            eachClient.setClientPassword("Default");
            clientRepository.save(eachClient);
            changeCode++;
        }
        return changeCode;
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow();
    }

    @Override
    public UserDetailsService userDetailsService() {
        return null;
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
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
    public Client findByLogin(String clientLogin) {

        return clientRepository.findByClientLogin(clientLogin);
    }

    @Override
    public boolean existsByClientLogin(String clientLogin) {
        return clientRepository.existsByClientLogin(clientLogin);
    }

    @Override
    public String save(Client client) {
       return clientRepository.save(client).getClientLogin();

    }

    @Override
    public boolean existByBuyerLoginAndEmail(String clientLogin, String clientEmail) {
        return clientRepository.existsByClientLoginAndClientEmail(clientLogin,clientEmail);
    }
}
