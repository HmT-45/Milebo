package com.example.milebo.feature.product.admin;

import com.example.milebo.feature.product.dto.ProductCreateRequest;
import com.example.milebo.feature.product.dto.ProductUpdateRequest;
import com.example.milebo.feature.product.model.Product;
import com.example.milebo.feature.category.service.CategoryService;
import com.example.milebo.feature.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/product")
@RequiredArgsConstructor
public class ProductAdminController {

    private final ProductService productService;
    private final CategoryService categoryService;

    // ================== LIST ==================
    @GetMapping
    public String index(Model model) {
        model.addAttribute("items", productService.findAll());
        model.addAttribute("content", "admin/product/index");
        return "admin/layout";
    }

    // ================== CREATE ==================
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new ProductCreateRequest());
        model.addAttribute("categories", categoryService.findAllActive());
        model.addAttribute("content", "admin/product/create");
        return "admin/layout";
    }

    @PostMapping("/save")
    public String save(
            @ModelAttribute("product") ProductCreateRequest req,
            Model model
    ) {
        try {
            productService.create(req);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("categories", categoryService.findAllActive());
            model.addAttribute("content", "admin/product/create");
            return "admin/layout";
        }
        return "redirect:/admin/product";
    }

    // ================== EDIT ==================
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        Product p = productService.findById(id);

        ProductUpdateRequest dto = new ProductUpdateRequest();
        dto.setId(p.getId());
        dto.setName(p.getName());
        dto.setDescription(p.getDescription());
        dto.setPrice(p.getPrice());
        dto.setQuantity(p.getQuantity());
        dto.setCategoryId(p.getCategory().getId());
        dto.setStatus(p.getStatus());
        dto.setImage(p.getImage());

        model.addAttribute("product", dto);
        model.addAttribute("categories", categoryService.findAllActive());
        model.addAttribute("content", "admin/product/edit");
        return "admin/layout";
    }

    @PostMapping("/update")
    public String update(
            @ModelAttribute("product") ProductUpdateRequest req,
            Model model
    ) {
        try {
            productService.update(req);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("categories", categoryService.findAllActive());
            model.addAttribute("content", "admin/product/edit");
            return "admin/layout";
        }
        return "redirect:/admin/product";
    }
}

