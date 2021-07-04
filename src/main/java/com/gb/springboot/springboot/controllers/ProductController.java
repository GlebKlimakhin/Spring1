package com.gb.springboot.springboot.controllers;

import com.gb.springboot.springboot.models.Product;
import com.gb.springboot.springboot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/all")
    public String showAllProducts(Model model){
        model.addAttribute("products", service.getAllProducts());
        return "all_products";
    }

    @GetMapping("/find")
    @ResponseBody
    public Product getProductById(@RequestParam Long id){
        return service.getProductById(id);
    }

    @PostMapping("add")
    public String addNewProduct(@ModelAttribute Product product){
        service.addProduct(product);
        return "redirect:/all";
    }

}
