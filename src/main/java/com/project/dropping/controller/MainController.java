package com.project.dropping.controller;

import com.project.dropping.model.Client;
import com.project.dropping.services.ClientService;
import com.project.dropping.services.RoleService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping("main/")
@RequiredArgsConstructor
public class MainController {

  final ClientService clientService;

  final RoleService roleService;

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
    // clientService.bringingTheDatabaseIntoValidForm(userList,userServiceInreface);
    if (!clientService.existByBuyerLoginAndEmail(userLogin,userEmail)) {
      clientService.save(new Client(UUID.randomUUID() + clientService.hashMD5(userLogin),userEmail,userLogin,userLogin,new BCryptPasswordEncoder().encode(userPassword),roleService.getUserRole()));
      return "redirect:/main/login";
    }
    return "redirect:/main/AnyException";
  }

 /* @PostMapping("/login")
  public String SingIn(
      @NonNull @RequestParam String username,
      @NonNull @RequestParam String password) {
    Iterable<Client> userList = clientService.findAll();
    for (Client testBuyer : userList) {
      if (username.equals(testBuyer.getBuyerName())
          && password.equals(testBuyer.getUserPassword())) {
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
