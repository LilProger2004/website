package com.project.dropping.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class TestController {
    @GetMapping("/")
    public String mainPageOfProduct(Model model) {
        return "main-page";
    }

    @GetMapping("/c/l")
    public String maeOfProduct(Model model) {
        return "test";
    }
}
