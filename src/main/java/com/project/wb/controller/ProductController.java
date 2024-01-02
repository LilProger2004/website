package com.project.wb.controller;

import com.project.wb.model.Product;
import com.project.wb.repo.ProductServiceInterface;
import com.project.wb.repo.UserServiceInreface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    ProductServiceInterface productServiceInterface;
    UserServiceInreface userServiceInreface;


    public ProductController(ProductServiceInterface productServiceInterface, UserServiceInreface userServiceInreface) {
        this.productServiceInterface = productServiceInterface;
        this.userServiceInreface = userServiceInreface;
    }

    @GetMapping("/")
    public String mainPageOfProduct(Model model){
        Product product = new Product(12L,"Rap",123,"Best product");
        //Iterable<Product> products = productServiceInterface.findAll();
        model.addAttribute("product",product);
        return "main-page";
    }
}
