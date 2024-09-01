package com.project.dropping.controller;

import com.project.dropping.model.Buyer;
import com.project.dropping.services.BuyerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("user/")
@RequiredArgsConstructor
public class BuyerController {
    final BuyerService buyerService;

    @GetMapping("/PersonalAccount/{userLogin}")
    public String userAccount(Model model, @PathVariable("userLogin") String userLogin) {
        if (!buyerService.existsByUserLogin(userLogin)) {
            return "redirect:/AnyException";
        }
        Buyer currentBuyer = buyerService.findByLogin(userLogin);
        buyerService.bringingTheDatabaseIntoValidForm(currentBuyer);
        model.addAttribute("userData", currentBuyer);

        return "userPageByReplitAI";
    }
}
