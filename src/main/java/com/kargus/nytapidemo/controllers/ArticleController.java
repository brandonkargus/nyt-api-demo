package com.kargus.nytapidemo.controllers;

import com.kargus.nytapidemo.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("articleList", articleService.getMostPopular());
        return "index";
    }

    @GetMapping("/search")
    public String searchHome(Model model) {

        return "search.html";
    }

    @PostMapping("/search")
    public String showResults(Model model, @RequestParam String keyword) {
       model.addAttribute("searchResults", articleService.getSearchResults(keyword));
       model.addAttribute("keyword", keyword);
       return "search.html";
    }
}

