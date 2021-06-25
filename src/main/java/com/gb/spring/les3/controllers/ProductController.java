package com.gb.spring.les3.controllers;

import com.gb.spring.les3.models.Product;
import com.gb.spring.les3.repositories.ProductRepository;
import com.gb.spring.les3.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public String getAllProducts(Model model){
        List<Product> productsList = service.getAllProducts();
        model.addAttribute("products", productsList);
        return "all_products";
    }

    @PostMapping("/add")
    public String addNewProduct(@ModelAttribute Product product){
        service.addProduct(product);
        return "redirect:/all";
    }
}
