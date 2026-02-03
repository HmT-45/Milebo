package com.example.milebo.feature.home.web;

import com.example.milebo.feature.category.repository.CategoryRepository;
import com.example.milebo.feature.home.service.UIControllerService;
import com.example.milebo.feature.product.service.ProductClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UIController {

    private final CategoryRepository categoryRepo;
    private final ProductClientService productClientService;
    private final UIControllerService uiControllerService;

    @GetMapping({"/", "/home"})
    public String home(Model model) {

        model.addAttribute("categories", categoryRepo.findAllActive());
        model.addAttribute("items", productClientService.getActiveProducts());
        model.addAttribute(
                "blocks",
                uiControllerService.getHomeBlocks()
        );
        model.addAttribute("content", "client/product/index");
        return "client/layout/main";
    }
}
