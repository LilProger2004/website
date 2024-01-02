package com.project.wb.controller;

import com.project.wb.model.Product;
import com.project.wb.repo.ProductServiceInterface;
import com.project.wb.repo.UserServiceInreface;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class ProductController {

    ProductServiceInterface productServiceInterface;
    UserServiceInreface userServiceInreface;


    public ProductController(ProductServiceInterface productServiceInterface, UserServiceInreface userServiceInreface) {
        this.productServiceInterface = productServiceInterface;
        this.userServiceInreface = userServiceInreface;
    }

    @GetMapping("/")
    public String mainPageOfProduct(Model model){
        Product product = new Product();
        Iterable<Product> products = productServiceInterface.findAll();
        model.addAttribute("products",products);
        return "main-page";
    }
}
