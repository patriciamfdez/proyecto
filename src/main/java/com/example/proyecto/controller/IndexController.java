package com.example.proyecto.controller;

import com.example.proyecto.data.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

//Página de inicio
@Controller
public class IndexController {
//    @Autowired
//    public IndexController(MenuService menuService){
//        super(menuService);
//    }

    @GetMapping("/")

    public String muestraIndex(ModelMap model){
        final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("username", ((UserEntity) principal).getName());
        return "index";

    }
}
