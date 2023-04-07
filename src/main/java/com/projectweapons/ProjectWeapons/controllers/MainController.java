package com.projectweapons.ProjectWeapons.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String cover(Model model) {
        model.addAttribute("title", "Project Weapons");
        return "mainCover";
    }

}