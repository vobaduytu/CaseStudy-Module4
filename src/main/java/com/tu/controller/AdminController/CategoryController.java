package com.tu.controller.AdminController;


import com.tu.model.Category;
import com.tu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/category")
    public String tables(Model model, Pageable pageable){
        model.addAttribute("list", categoryService.showAll(pageable));
        return "category";
    }

    @GetMapping("/addCategory")
    public String showAdd(Model model){
        model.addAttribute("category", new Category());
        return "add-category";
    }
    @PostMapping("/doAdd")
    public String doAdd(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes){
       
        categoryService.save(category);
        return "redirect:/category";
    }

}
