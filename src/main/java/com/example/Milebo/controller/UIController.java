package com.example.Milebo.controller;

import com.example.Milebo.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class UIController {

    private final CategoryRepository categoryRepository;
    @GetMapping("/home")
    String home(Model model){
            model.addAttribute("categories", categoryRepository.findAll());
        return "/layout/main";
    }
}
