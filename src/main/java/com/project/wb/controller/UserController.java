package com.project.wb.controller;

import com.project.wb.model.User;
import com.project.wb.repo.ProductServiceInterface;
import com.project.wb.repo.UserServiceInreface;
import com.project.wb.services.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class UserController {
    ProductServiceInterface productServiceInterface;
    UserServiceInreface userServiceInreface;
    UserService userService = new UserService();


    public UserController(ProductServiceInterface productServiceInterface, UserServiceInreface userServiceInreface) {
        this.productServiceInterface = productServiceInterface;
        this.userServiceInreface = userServiceInreface;
    }

    @GetMapping("/PersonalAccount/{id}")
    public String userAccount(Model model, @PathVariable("id") Long id) {
        if (!userServiceInreface.existsById(id)) {
            return "redirect:/AnyException";
        }
        User currentUser = userServiceInreface.findById(id).orElseThrow();
        userService.bringingTheDatabaseIntoProperForm(currentUser, userServiceInreface);
        model.addAttribute("userData", currentUser);
        return "UserPage";
    }
}
