package com.project.dropping.controller;

import com.project.dropping.model.Category;
import com.project.dropping.model.Product;
import com.project.dropping.repository.CategoryServiceInterface;
import com.project.dropping.repository.ProductServiceInterface;
import com.project.dropping.repository.UserServiceInterface;
import com.project.dropping.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ProductController {

  final ProductServiceInterface productServiceInterface;

  final UserServiceInterface userServiceInterface;

  final CategoryServiceInterface categoryServiceInterface;

  final ProductService productService;
  @GetMapping("/Products")
  public String mainPageOfProduct(Model model) {
    Iterable<Product> products = productServiceInterface.findAll();
    Iterable<Category> categories = categoryServiceInterface.findAll();
    model.addAttribute("categories", categories);
    model.addAttribute("products", products);
    return "products-page";
  }
}
