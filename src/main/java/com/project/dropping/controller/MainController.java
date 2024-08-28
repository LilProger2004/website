package com.project.dropping.controller;

import ch.qos.logback.core.model.Model;
import com.project.dropping.model.Buyer;
import com.project.dropping.repository.UserServiceInterface;
import com.project.dropping.services.BuyerService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MainController {
  final UserServiceInterface userServiceInterface;
  final BuyerService buyerService;
  boolean flag = true;
  @GetMapping("/")
  public String welcomePageView() {
    return "start-page";
  }

  @GetMapping("/login")
  public String loggingPageGet(org.springframework.ui.Model model) {
    return "SignIn2";
  }

  @GetMapping("/register")
  public String registrationPageGet(org.springframework.ui.Model model) {
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
      @NonNull @RequestParam String userEmail,
      @NonNull @RequestParam String userName) {
    Iterable<Buyer> userList = userServiceInterface.findAll();
    // buyerService.bringingTheDatabaseIntoValidForm(userList,userServiceInreface);
    for (Buyer testBuyer : userList) {
      if ((userLogin.equals(testBuyer.getBuyerLogin()))
          && userEmail.equals(testBuyer.getBuyerEmail())) {
        flag = false;
        break;
      }
    }
    if (flag) {
      Buyer newBuyer = new Buyer();
      newBuyer.setBuyerId(userLogin);
      newBuyer.setBuyerName(userName);
      newBuyer.setBuyerLogin(userLogin);
      newBuyer.setBuyerPassword(userPassword);
      newBuyer.setBuyerEmail(userEmail);
      userServiceInterface.save(newBuyer);
      return "redirect:/PersonalAccount/" + newBuyer.getBuyerLogin().toString();
    }
    return "Sorry";
  }

  @PostMapping("/login")
  public String SingIn(
      @NonNull @RequestParam String user_email,
      @NonNull @RequestParam String user_password) {
    Iterable<Buyer> userList = userServiceInterface.findAll();
    for (Buyer testBuyer : userList) {
      if (user_email.equals(testBuyer.getBuyerEmail())
          && user_password.equals(testBuyer.getBuyerPassword())) {
        return "redirect:/PersonalAccount/" + testBuyer.getBuyerLogin().toString();
      }
    }

    return "redirect:/login";
  }
}
