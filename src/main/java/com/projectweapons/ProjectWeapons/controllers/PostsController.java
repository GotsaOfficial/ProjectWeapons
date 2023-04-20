package com.projectweapons.ProjectWeapons.controllers;

import com.projectweapons.ProjectWeapons.models.PostsModel;
import com.projectweapons.ProjectWeapons.repo.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class PostsController {

    @Autowired
    private PostsRepository postsRepository;

    @GetMapping("/posts")
    public String posts(Model model) {
        model.addAttribute("title1", "PW | Публикации");
        model.addAttribute("title2", "Project Weapons");
        Iterable<PostsModel> posts = postsRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("posts", posts);
        return "posts";
    }

    @GetMapping("/posts/add")
    public String postsAdd(Model model) {
        model.addAttribute("title1", "PW | Публикации");
        model.addAttribute("title2", "Project Weapons");
        return "postsAdd";
    }

    @PostMapping("/posts/add")
    public String postsAdd(@RequestParam String title, @RequestParam String minitext, @RequestParam String text, Model model) {
        model.addAttribute("title1", "PW | Публикации");
        model.addAttribute("title2", "Project Weapons");
        PostsModel post = new PostsModel(title, minitext, text);
        postsRepository.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}")
    public String postsFullText(@PathVariable(value = "id") long id, Model model) {
        if(!postsRepository.existsById(id)) {
            return "redirect:/posts";
        }

        PostsModel postV = postsRepository.findById(id).orElseThrow();
        postV.setViews(postV.getViews() + 1);
        postsRepository.save(postV);

        Optional<PostsModel> post = postsRepository.findById(id);
        ArrayList<PostsModel> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("title1", "PW | Публикации");
        model.addAttribute("title2", "Project Weapons");
        model.addAttribute("post", res);
        return "postsFullText";
    }

    @GetMapping("/posts/{id}/edit")
    public String postsEdit(@PathVariable(value = "id") long id, Model model) {
        if(!postsRepository.existsById(id)) {
            return "redirect:/posts";
        }

        Optional<PostsModel> post = postsRepository.findById(id);
        ArrayList<PostsModel> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("title1", "PW | Публикации");
        model.addAttribute("title2", "Project Weapons");
        model.addAttribute("post", res);
        return "postsEdit";
    }

    @PostMapping("/posts/{id}/edit")
    public String postsEditUpload(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String minitext, @RequestParam String text, Model model) {
        model.addAttribute("title1", "PW | Публикации");
        model.addAttribute("title2", "Project Weapons");
        PostsModel post = postsRepository.findById(id).orElseThrow();
        post.setTitle(title);
        post.setMinitext(minitext);
        post.setText(text);
        postsRepository.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/del")
    public String postsEditDel(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("title1", "PW | Публикации");
        model.addAttribute("title2", "Project Weapons");
        PostsModel post = postsRepository.findById(id).orElseThrow();
        postsRepository.delete(post);
        return "redirect:/posts";
    }
}
