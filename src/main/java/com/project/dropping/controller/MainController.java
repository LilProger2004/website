package com.project.dropping.controller;

import com.project.dropping.config.auth.AuthenticationService;
import com.project.dropping.services.ClientService;
import com.project.dropping.services.RoleService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main/")
@RequiredArgsConstructor
public class MainController {

  final ClientService clientService;

  final RoleService roleService;

  final AuthenticationService authenticationService;

  @GetMapping("/")
  public String welcomePageView() {
    return "main-page";
  }

  @GetMapping("/error")
  public String getError(Model model) {
    model.addAttribute("error",new Exception().getMessage());
    return "error";
  }

  @GetMapping("/login")
  public String loggingPageGet() {
    return "SignIn2";
  }

  @GetMapping("/logout")
  public String logoutPageGet() {
    return "logout";
  }

  @GetMapping("/welcome")
  public String welcomePageGet() {
    return "start-page";
  }

  @GetMapping("/register")
  public String registrationPageGet() {
    return "SignUp";
  }

  @GetMapping("/AnyException")
  public String exceptionPage() {
    return "Sorry";
  }

  @GetMapping("/SignInException")
  public String signInExcHandler() {
    return "SorrySignIn";
  }

  /*@PostMapping("/register")
  public String SingUp(
      Model model,
      @NonNull @RequestParam String userLogin,
      @NonNull @RequestParam String userPassword,
      @NonNull @RequestParam String userEmail) {
    // clientService.bringingTheDatabaseIntoValidForm(userList,userServiceInreface);
    if (!clientService.existByBuyerLoginAndEmail(userLogin,userEmail)) {
      clientService.save(new Client(UUID.randomUUID() + clientService.hashMD5(userLogin),userEmail,userLogin,userL,roleService.getUserRole()));
      return "redirect:/main/login";
    }
    return "redirect:/main/AnyException";
  }*/

  @GetMapping("/testPage")
  public String viewTestUser(Model model, HttpServletResponse response) {
    return "SignIn";
  }
}
