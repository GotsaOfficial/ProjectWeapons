package com.projectweapons.ProjectWeapons.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {

    @GetMapping("/login")
    public String greeting(Model model) {
        model.addAttribute("title1", "PW | Войти");
        model.addAttribute("title2", "Project Weapons");
        return "signin";
    }

}
