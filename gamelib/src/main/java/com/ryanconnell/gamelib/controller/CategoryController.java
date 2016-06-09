package com.ryanconnell.gamelib.controller;


import com.ryanconnell.gamelib.data.CategoryRepository;
import com.ryanconnell.gamelib.data.GameRepository;
import com.ryanconnell.gamelib.model.Category;
import com.ryanconnell.gamelib.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GameRepository gameRepository;

    @RequestMapping("/categories")
    public String ListCategories(ModelMap modelMap){
        List<Category> categories = categoryRepository.getAllCategories();
        modelMap.put("categories", categories);
        return "categories";
    }

    @RequestMapping("/category/{id}")
    public String category(@PathVariable int id, ModelMap modelMap){
        Category category = categoryRepository.findById(id);
        modelMap.put("category", category);

        List<Game> games = gameRepository.findByCategoryId(id);
        modelMap.put("games",games);

        return "category";
    }
}
