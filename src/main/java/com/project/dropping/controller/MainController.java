package com.project.dropping.controller;

import ch.qos.logback.core.model.Model;
import com.project.dropping.model.User;
import com.project.dropping.repo.UserServiceInterface;
import com.project.dropping.services.UserService;
import lombok.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {
    UserServiceInterface userServiceInterface;
    boolean flag = true;
    UserService userService = new UserService();

    public MainController(UserServiceInterface userServiceInterface) {
        this.userServiceInterface = userServiceInterface;
    }


    @GetMapping("/")
    public String welcomePageView() {
        return "start-page";
    }


    @GetMapping("/login")
    public String loggingPageGet(org.springframework.ui.Model model) {
        return "SignIn";
    }

    @GetMapping("/register")
    public String registrationPageGet(org.springframework.ui.Model model) {
        return "SignUp";
    }

    @GetMapping("/AnyException")
    public String exceptionPage(Model model) {
        return "Sorry";
    }


    @PostMapping("/register")
    public String SingUp(Model model, @NonNull @RequestParam String user_login, @NonNull @RequestParam String user_password, @NonNull @RequestParam String user_email) {
        Iterable<User> userList = userServiceInterface.findAll();
        //userService.bringingTheDatabaseIntoProperForm(userList,userServiceInreface);
        String hashUserPassword = String.valueOf(user_password.hashCode());
        for (User testUser :
                userList) {
            if ((user_login.equals(testUser.getUser_login())) && user_email.equals(testUser.getUser_email())) {
                flag = false;
                break;
            }
        }
        if (flag) {
            User newUser = new User();
            newUser.setUser_login(user_login);
            newUser.setUser_password(hashUserPassword);
            newUser.setUser_email(user_email);
            userServiceInterface.save(newUser);
            return "redirect:/PersonalAccount/" + newUser.getId().toString();
        }
        return "Sorry";
    }

    @PostMapping("/login")
    public String SingIn(Model model, @NonNull @RequestParam String user_login, @NonNull @RequestParam String user_password) {
        Iterable<User> userList = userServiceInterface.findAll();
        for (User testUser :
                userList) {
            if (user_login.equals(testUser.getUser_login()) && user_password.equals(testUser.getUser_password())) {
                return "redirect:/PersonalAccount/" + testUser.getId().toString();
            }
        }

        return "Sorry";
    }
}
