package com.tu.controller.AdminController;


import com.tu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public String listProduct(Model model, Pageable pageable){
        model.addAttribute("list",productService.showAll(pageable));
        return "product-list";
    }
}
