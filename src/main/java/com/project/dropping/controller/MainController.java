package com.project.dropping.controller;

import com.project.dropping.model.Buyer;
import com.project.dropping.services.BuyerService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("main/")
@RequiredArgsConstructor
public class MainController {
  final BuyerService buyerService;
  boolean flag = true;
  @GetMapping("/")
  public String welcomePageView() {
    return "start-page";
  }

  @GetMapping("/error")
  public String getError(Model model) {
    model.addAttribute("error",new Exception().getMessage());
    return "error";
  }

  @GetMapping("/login")
  public String loggingPageGet(org.springframework.ui.Model model) {
    return "SignIn2";
  }

  @GetMapping("/register")
  public String registrationPageGet(Model model) {
    return "SignUp";
  }

  @GetMapping("/AnyException")
  public String exceptionPage(Model model) {
    return "Sorry";
  }

  @GetMapping("/SignInException")
  public String signInExcHandler() {
    return "SorrySignIn";
  }

  @PostMapping("/register")
  public String SingUp(
      Model model,
      @NonNull @RequestParam String userLogin,
      @NonNull @RequestParam String userPassword,
      @NonNull @RequestParam String userEmail) {
    // buyerService.bringingTheDatabaseIntoValidForm(userList,userServiceInreface);
    if (buyerService.existByBuyerLoginAndEmail(userLogin,userEmail)) {
      Buyer newBuyer = new Buyer();
      newBuyer.setBuyerId(buyerService.hashMD5(userLogin));
      newBuyer.setBuyerName("lary");
      newBuyer.setBuyerLogin(userLogin);
      newBuyer.setBuyerPassword(new BCryptPasswordEncoder().encode(userPassword));
      newBuyer.setBuyerEmail(userEmail);
      buyerService.save(newBuyer);
      return "redirect:/user/PersonalAccount/" + newBuyer.getBuyerLogin().toString();
    }
    return "Sorry";
  }

 /* @PostMapping("/login")
  public String SingIn(
      @NonNull @RequestParam String username,
      @NonNull @RequestParam String password) {
    Iterable<Buyer> userList = buyerService.findAll();
    for (Buyer testBuyer : userList) {
      if (username.equals(testBuyer.getBuyerName())
          && password.equals(testBuyer.getBuyerPassword())) {
        System.out.println("method working");
        return "redirect:/user/PersonalAccount/" + testBuyer.getBuyerLogin().toString();
      }
    }
    return "redirect:/";
  }*/

  @GetMapping("/testPage")
  public String viewTestUser(Model model) {
    return "SignIn2";
  }
}
