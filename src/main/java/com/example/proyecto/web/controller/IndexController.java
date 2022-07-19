package com.example.proyecto.web.controller;

import com.example.proyecto.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class IndexController extends AbstractController {

    @Autowired
    public IndexController(MenuService menuService) {
        super(menuService);
    }

    @GetMapping({"/",""})
    public String indexPage(ModelMap model) {
//        final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        model.addAttribute("username", ((User) principal).getUserName());
        return "index";
    }

    @GetMapping("/index")
    public String indexPage1(ModelMap model) {
//        final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        model.addAttribute("username", ((User) principal).getUserName());
        return "index";
    }
}
