package com.project.dropping.controller;

import com.project.dropping.model.Client;
import com.project.dropping.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("client/")
@RequiredArgsConstructor
public class ClientController {
    final ClientService clientService;

    @GetMapping("/PersonalAccount/{userLogin}")
    public String viewUserInfo(Model model, @PathVariable("userLogin") String userLogin) {
        if (!clientService.existsByUserLogin(userLogin)) {
            return "redirect:/AnyException";
        }
        Client currentClient = clientService.findByLogin(userLogin);
        clientService.bringingTheDatabaseIntoValidForm(currentClient);
        model.addAttribute("userData", currentClient);

        return "userPageByReplitAI";
    }
}
