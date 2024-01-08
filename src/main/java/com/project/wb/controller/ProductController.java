package com.project.wb.controller;

import com.project.wb.model.Product;
import com.project.wb.repo.ProductServiceInterface;
import com.project.wb.repo.UserServiceInreface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    ProductServiceInterface productServiceInterface;
    UserServiceInreface userServiceInreface;


    public ProductController(ProductServiceInterface productServiceInterface, UserServiceInreface userServiceInreface) {
        this.productServiceInterface = productServiceInterface;
        this.userServiceInreface = userServiceInreface;
    }

    @GetMapping("/opoo")
    public String mainPageOfProduct(Model model){
        Iterable<Product> products = productServiceInterface.findAll();
        model.addAttribute("product",products);
        return "main-page";
    }
}
