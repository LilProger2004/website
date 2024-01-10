package com.project.wb.services;

import com.project.wb.model.User;
import com.project.wb.repo.UserServiceInreface;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void bringingTheDatabaseIntoProperForm(Iterable<User> userList, UserServiceInreface userServiceInreface) {
        for (User eachUser:
                userList) {
            if (eachUser.getUser_email() == null || eachUser.getUser_email().isEmpty()){
                eachUser.setUser_email("Default");
                userServiceInreface.save(eachUser);
            }
            if (eachUser.getUser_login() == null || eachUser.getUser_login().isEmpty()) {
                eachUser.setUser_login("Default");
                userServiceInreface.save(eachUser);
            }
        }
    }
}
