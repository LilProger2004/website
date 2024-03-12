package com.project.dropping.services;

import com.project.dropping.repo.UserServiceInterface;
import com.project.dropping.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public byte bringingTheDatabaseIntoProperForm(User eachUser, UserServiceInterface userServiceInterface) {
        byte changeCode= 0;
        if (eachUser.getUser_email() == null || eachUser.getUser_email().isEmpty()) {
            eachUser.setUser_email("Default");
            userServiceInterface.save(eachUser);
            changeCode ++;
        }
        if (eachUser.getUser_login() == null || eachUser.getUser_login().isEmpty()) {
            eachUser.setUser_login("Default");
            userServiceInterface.save(eachUser);
            changeCode++;
        }
        if (eachUser.getUser_name() == null || eachUser.getUser_name().isEmpty()) {
            eachUser.setUser_name("Default");
            userServiceInterface.save(eachUser);
            changeCode++;
        }
        if (eachUser.getUser_password() == null || eachUser.getUser_password().isEmpty()) {
            eachUser.setUser_password("Default");
            userServiceInterface.save(eachUser);
            changeCode++;
        }
        return changeCode;
    }
}

