package uws.edu.ii.springlaby2.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import uws.edu.ii.springlaby2.models.Category;
import uws.edu.ii.springlaby2.repositories.CategoryRepository;

@Controller
@RequestMapping("/category")
public class CategoryController {
    //Wstrzyknięcie zależności z wykorzystaniem pola
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/list")
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "categoryList";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("category", new Category());
        return "categoryForm";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono kategorii o ID: " + id));
        model.addAttribute("category", category);
        return "categoryForm";
    }

    @PostMapping("/save")
    public String saveCategory(@Valid @ModelAttribute Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "categoryForm";
        }

        categoryRepository.save(category);
        return "redirect:/category/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryRepository.deleteById(id);
        return "redirect:/category/list";
    }
}