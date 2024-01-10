package com.project.wb.controller;

import ch.qos.logback.core.model.Model;
import com.project.wb.model.User;
import com.project.wb.repo.UserServiceInreface;
import com.project.wb.services.UserService;
import lombok.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    UserServiceInreface userServiceInreface;
    boolean flag = true;
    UserService userService = new UserService();

    public MainController(UserServiceInreface userServiceInreface) {
        this.userServiceInreface = userServiceInreface;
    }

    @GetMapping("/")
    public String logingPageGet(org.springframework.ui.Model model) {
        return "WelcomePage";
    }

    @GetMapping("/register")
    public String registrationPageGet(org.springframework.ui.Model model) {
        return "reg";
    }


    @PostMapping("/register")
    public String SingUp(Model model, @NonNull @RequestParam String user_login, @NonNull @RequestParam String user_password, @NonNull @RequestParam String user_email) {
        Iterable<User> userList = userServiceInreface.findAll();
        userService.bringingTheDatabaseIntoProperForm(userList,userServiceInreface);
        for (User testUser :
                userList) {
            if (testUser.getUser_login() != null && testUser.getUser_email() != null) {
                if ((user_login.equals(testUser.getUser_login())) && user_email.equals(testUser.getUser_email())) {
                    flag = false;
                    break;
                }
            }
        }
        if (flag) {
            User newUser = new User();
            newUser.setUser_login(user_login);
            newUser.setUser_password(user_password);
            newUser.setUser_email(user_email);
            userServiceInreface.save(newUser);
            return "redirect:/opoo";
        }
        return "Sorry";
    }

    @PostMapping("/")
    public String SingIn(Model model, @NonNull @RequestParam String user_login, @NonNull @RequestParam String user_password) {
        Iterable<User> userList = userServiceInreface.findAll();
        for (User testUser :
                userList) {
            if (testUser.getUser_login() != null && testUser.getUser_password() != null) {
                if (user_login.equals(testUser.getUser_login()) && user_password.equals(testUser.getUser_password())) {
                    return "redirect:/opoo";
                }
            }

        }

        return "Sorry";
    }
}
