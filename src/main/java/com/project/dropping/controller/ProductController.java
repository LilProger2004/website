package com.project.dropping.controller;

import com.project.dropping.model.Product;
import com.project.dropping.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("product/")
@RequiredArgsConstructor
public class ProductController {

  final ProductService productService;
  @GetMapping("/Products")
  public String mainPageOfProduct(Model model) {
    Iterable<Product> products = productService.findAll();
    model.addAttribute("products", products);
    return "products-page";
  }

  @GetMapping("/testPage")
  public String viewTestUser(Model model) {
    return "SignIn2";
  }
}
