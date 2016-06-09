package com.ryanconnell.gamelib.data;

import com.ryanconnell.gamelib.model.Category;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryRepository {
    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
      new Category(1, "RPG"),
      new Category(2, "Action Adventure"),
      new Category(3, "Shooter"),
      new Category(4, "MOBA")
    );

    public List<Category> getAllCategories(){
        return ALL_CATEGORIES;
    }

    public Category findById(int id){
        for(Category category : ALL_CATEGORIES){
            if(category.getId() == id){
                return category;
            }
        }
        return null;
    }
}
