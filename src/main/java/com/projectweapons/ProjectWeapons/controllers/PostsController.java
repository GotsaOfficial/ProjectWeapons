package com.projectweapons.ProjectWeapons.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostsController {

    @GetMapping("/posts")
    public String greeting(Model model) {
        model.addAttribute("title1", "PW | Публикации");
        model.addAttribute("title2", "Project Weapons");
        return "posts";
    }

}
