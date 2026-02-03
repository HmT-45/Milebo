package com.example.milebo.feature.category.admin;

import com.example.milebo.feature.category.dto.CategoryCreateRequest;
import com.example.milebo.feature.category.dto.CategoryUpdateRequest;
import com.example.milebo.feature.category.model.Category;
import com.example.milebo.feature.category.repository.CategoryRepository;
import com.example.milebo.feature.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/category")
public class CategoryAdminController {

    @Autowired
    private CategoryService service;

    @Autowired
    private CategoryRepository repo;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("items", repo.findAll());
        model.addAttribute("content", "admin/category/index");
        return "admin/layout";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("category", new CategoryCreateRequest());
        model.addAttribute("content", "admin/category/create");
        return "admin/layout";
    }

    @PostMapping("/save")
    public String save(
            @ModelAttribute("category") CategoryCreateRequest req,
            Model model) {
        try {
            service.create(req.getName(), req.getStatus()) ;
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("category", req);
            model.addAttribute("content", "admin/category/create");
            return "admin/layout";
        }
        return "redirect:/admin/category";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        Category c = service.findById(id);

        CategoryUpdateRequest dto = new CategoryUpdateRequest();
        dto.setId(c.getId());
        dto.setName(c.getName());
        dto.setStatus(c.getStatus());

        model.addAttribute("category", dto);
        model.addAttribute("content", "admin/category/edit");
        return "admin/layout";
    }


    @PostMapping("/update")
    public String update(
            @ModelAttribute("category") CategoryUpdateRequest req,
            Model model
    ) {
        try {
            service.update(req);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("content", "admin/category/edit");
            return "admin/layout";
        }
        return "redirect:/admin/category";
    }
}



