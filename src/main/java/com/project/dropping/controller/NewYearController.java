package com.project.dropping.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class NewYearController {

    @GetMapping("/companyName")
    public String welcomePageView() {
        return "company-name";
    }
}
