package com.project.dropping.controller;

import com.project.dropping.model.Category;
import com.project.dropping.repo.CategoryServiceInterface;
import com.project.dropping.repo.ProductServiceInterface;
import com.project.dropping.repo.UserServiceInterface;
import com.project.dropping.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    ProductServiceInterface productServiceInterface;
    UserServiceInterface userServiceInterface;

    CategoryServiceInterface categoryServiceInterface;
    public ProductController(ProductServiceInterface productServiceInterface, UserServiceInterface userServiceInterface, CategoryServiceInterface categoryServiceInterface) {
        this.productServiceInterface = productServiceInterface;
        this.userServiceInterface = userServiceInterface;
        this.categoryServiceInterface = categoryServiceInterface;
    }

    @GetMapping("/Products")
    public String mainPageOfProduct(Model model){
        Iterable<Product> products = productServiceInterface.findAll();
        Iterable<Category> categories = categoryServiceInterface.findAll();
        model.addAttribute("categories",categories);
        model.addAttribute("products",products);
        return "products-page";
    }
}
