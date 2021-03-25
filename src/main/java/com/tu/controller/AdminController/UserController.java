package com.tu.controller.AdminController;

import com.tu.repository.UserRepository;
import com.tu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public String showUser(Model model, Pageable pageable){
        model.addAttribute("list", userService.showAll(pageable));
        return "user-list";
    }
}
