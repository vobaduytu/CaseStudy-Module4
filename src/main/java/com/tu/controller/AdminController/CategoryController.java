package com.tu.controller.AdminController;


import com.tu.model.Category;
import com.tu.model.User;
import com.tu.repository.CategoryRepository;
import com.tu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryRepository categoryReponsitory;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/category")
    public String tables(Model model, Pageable pageable) {
        model.addAttribute("list", categoryService.showAll(pageable));
        Object mess = model.getAttribute("mess");
        System.out.println(mess);
        return "category-list";
    }

    @GetMapping("/addCategory")
    public String showAdd(Model model) {
        model.addAttribute("category", new Category());
        return "add-category";
    }

    @PostMapping("/doAdd")
    public String doAdd(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        try{
            if (bindingResult.hasErrors()){
                return "add-category";
            }
            String name = category.getName();
            List<Category> categoryTemps = categoryReponsitory.findByName(name);
            if (categoryTemps == null || categoryTemps.isEmpty()) {
                categoryService.save(category);
                redirectAttributes.addFlashAttribute("mess", "Th??m m???i th??nh c??ng...!!!");
            }else {
                redirectAttributes.addFlashAttribute("mess", "T??n Category ???? t???n t???i");
            }

            return "redirect:/category";
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("mess", "Rrororo");
            return "redirect:/category";
        }

    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable long id, RedirectAttributes redirectAttributes) {
        categoryService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "X??a th??nh c??ng...!!!");
        return "redirect:/category";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable long id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "edit-category";
    }


    @PostMapping("/doEdit")
    public String doEdit(@Valid @ModelAttribute("category") Category category,BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        try {
            if (bindingResult.hasErrors()){
                return "edit-category";
            }
            String name = category.getName();
            List<Category> categoryTemps = categoryReponsitory.findByName(name);
            if (categoryTemps == null || categoryTemps.isEmpty()) {
                categoryService.save(category);
                redirectAttributes.addFlashAttribute("mess", "S???a th??nh c??ng...!!!");
                return "redirect:/category";
            }
            redirectAttributes.addFlashAttribute("mess", "T??n Category ???? t???n t???i");

        } catch (Exception e) {
            e.getMessage();
            redirectAttributes.addFlashAttribute("mess", "Error");
        }
        return "redirect:/category";
    }
      @GetMapping("/garbageCategory")
    public String showdelete(Model model, Pageable pageable){
        model.addAttribute("list" , categoryReponsitory.findAllByDeletedIsTrue(pageable));
        return "category-list";
      }
}
