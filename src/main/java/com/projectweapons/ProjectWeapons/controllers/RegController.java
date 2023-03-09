package com.projectweapons.ProjectWeapons.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegController {

    @GetMapping("/registration")
    public String greeting(Model model) {
        model.addAttribute("title1", "PW | Registration");
        model.addAttribute("title2", "Project Weapons");
        return "reg";
    }

}
