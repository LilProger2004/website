package com.project.wb.services;

import com.project.wb.model.User;
import com.project.wb.repo.UserServiceInreface;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public byte bringingTheDatabaseIntoProperForm(User eachUser, UserServiceInreface userServiceInreface) {
        byte changeCode= 0;
        if (eachUser.getUser_email() == null || eachUser.getUser_email().isEmpty()) {
            eachUser.setUser_email("Default");
            userServiceInreface.save(eachUser);
            changeCode ++;
        }
        if (eachUser.getUser_login() == null || eachUser.getUser_login().isEmpty()) {
            eachUser.setUser_login("Default");
            userServiceInreface.save(eachUser);
            changeCode++;
        }
        if (eachUser.getUser_name() == null || eachUser.getUser_name().isEmpty()) {
            eachUser.setUser_name("Default");
            userServiceInreface.save(eachUser);
            changeCode++;
        }
        if (eachUser.getUser_password() == null || eachUser.getUser_password().isEmpty()) {
            eachUser.setUser_password("Default");
            userServiceInreface.save(eachUser);
            changeCode++;
        }
        return changeCode;
    }
}

