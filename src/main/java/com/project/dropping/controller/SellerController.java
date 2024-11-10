package com.project.dropping.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.dropping.model.Seller;
import com.project.dropping.services.SellerService;
import com.project.dropping.utils.FormatParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RequestMapping("seller/")
@Controller
public class SellerController {

    @Autowired
    SellerService sellerService;

    @Autowired
    FormatParser formatParser;

    @GetMapping("/{name}")
    public String viewSellerInfo(Model model, @PathVariable("name") String sellerName) {
        model.addAttribute("seller", sellerService.findSellerByName(sellerName));
        return "UserPage3.0";
    }


    @GetMapping(value ="/add")
    public String viewAddSeller() {
        return "sellerAdd";
    }


    @PostMapping("/add")
    public String addSeller(@RequestBody String newSeller) throws JsonProcessingException {
        Seller seller = new ObjectMapper().readValue(formatParser.urlEncodedToJson(newSeller), Seller.class);
        seller.setSellerId(UUID.randomUUID() + seller.getSellerLogin());
        sellerService.saveSeller(seller);
        return "redirect:/seller/" + seller.getSellerName();
    }

}
