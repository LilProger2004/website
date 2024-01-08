package com.project.wb.controller;

import ch.qos.logback.core.model.Model;
import com.project.wb.model.User;
import com.project.wb.repo.UserServiceInreface;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    UserServiceInreface userServiceInreface;

    public MainController(UserServiceInreface userServiceInreface) {
        this.userServiceInreface = userServiceInreface;
    }

    @GetMapping("/")
    public String logingPageGet(org.springframework.ui.Model model) {
        return "WelcomePage";
    }

    @PostMapping("/")
    public String SingIn(Model model, @RequestParam String user_login, @RequestParam String user_password) {
        User newUser = new User();
        newUser.setUser_login(user_login);
        newUser.setUser_password(user_password);
        userServiceInreface.save(newUser);
        return "redirect:/opoo";
    }

}
