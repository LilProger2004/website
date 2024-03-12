package com.project.dropping.controller;

import com.project.dropping.repo.ProductServiceInterface;
import com.project.dropping.repo.UserServiceInterface;
import com.project.dropping.model.Product;
import com.project.dropping.model.User;
import com.project.dropping.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    ProductServiceInterface productServiceInterface;
    UserServiceInterface userServiceInterface;
    UserService userService = new UserService();


    public UserController(ProductServiceInterface productServiceInterface, UserServiceInterface userServiceInterface) {
        this.productServiceInterface = productServiceInterface;
        this.userServiceInterface = userServiceInterface;
    }

    @GetMapping("/PersonalAccount/{id}")
    public String userAccount(Model model, @PathVariable("id") Long id) {
        if (!userServiceInterface.existsById(id)) {
            return "redirect:/AnyException";
        }
        User currentUser = userServiceInterface.findById(id).orElseThrow();
        userService.bringingTheDatabaseIntoProperForm(currentUser, userServiceInterface);
        Iterable<Product> products = productServiceInterface.findAll();
        List<Product> userProduct = new ArrayList<>();
        for (Product product:
             products) {
            if (product.getUser_id() == id){
                userProduct.add(product);
            }
        }
        model.addAttribute("products",userProduct);
        model.addAttribute("userData", currentUser);

        return "UserPage2.0";
    }

    @GetMapping("/testPage")
    public String viewTestUser(Model model, @PathVariable("id") Long id){
        return "test";
    }
}
