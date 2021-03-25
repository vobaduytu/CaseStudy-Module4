package com.tu.controller.AdminController;


import com.tu.model.Category;
import com.tu.model.Product;
import com.tu.repository.CategoryRepository;
import com.tu.repository.ProductReponsitory;
import com.tu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
  @Autowired
  private ProductReponsitory productReponsitory;
  @Autowired
  private CategoryRepository categoryRepository;
    @GetMapping("/product")
    public String listProduct(Model model, Pageable pageable){
        model.addAttribute("list",productService.showAll(pageable));
        return "product-list";
    }
    @GetMapping("/addProduct")
    public String showAdd(Model model){
        model.addAttribute("product",new Product());
        model.addAttribute("category",categoryRepository.findAll());
        return "add-product";
    }
    @PostMapping("addProduct")
    public String doAdd(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        try{
            if (bindingResult.hasErrors()){
                return "add-product";
            }
            String name = product.getName();
            List<Product> productList = productReponsitory.findByName(name);
            if (productList == null || productList.isEmpty()) {
                productService.save(product);
                redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công...!!!");
            }else {
                redirectAttributes.addFlashAttribute("mess", "Tên Category đã tồn tại");
            }

            return "redirect:/product";
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("mess", "Rrororo");
            return "redirect:/product";
        }

    }
    @GetMapping("/{id}/edits")
    public String showEdit(@PathVariable long id, Model model){
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("category",categoryRepository.findAll());
        return "edit-product";
    }
    @PostMapping("/editProduct")
     public String doEdit(@Valid @ModelAttribute("product") Product product,BindingResult bindingResult, RedirectAttributes redirectAttributes){
        try {
            if (bindingResult.hasErrors()){
                return "edit-product";
            }
            String name = product.getName();
            List<Product> productList = productReponsitory.findByName(name);
            if (productList == null || productList.isEmpty()) {
                productService.save(product);
                redirectAttributes.addFlashAttribute("mess", "Sửa thành công...!!!");
                return "redirect:/product";
            }
            redirectAttributes.addFlashAttribute("mess", "Tên Category đã tồn tại");

        } catch (Exception e) {
            e.getMessage();
            redirectAttributes.addFlashAttribute("mess", "Error");
        }
        return "redirect:/product";
    }

    @GetMapping("/{id}/deletes")
    public String delete(@PathVariable long id, RedirectAttributes redirectAttributes) {
        productService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công...!!!");
        return "redirect:/product";
    }
    @GetMapping("/{id}/views")
    public String showViews(@PathVariable long id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "view-product";
    }
    @GetMapping("/garbage")
    public String showDelete(Model model, Pageable pageable){
        model.addAttribute("list",productReponsitory.findAllByDeletedIsTrue(pageable));
        return "product-list";
    }
}
