package com.spring.blog.services;

import com.spring.blog.entities.Category;
import com.spring.blog.exceptions.ResourceNotFoundException;
import com.spring.blog.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;


    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Category category, Integer categoryId) {
        Category categoryObj = categoryRepository.findById(categoryId).orElseThrow(() ->
                new ResourceNotFoundException("Category", "category id", categoryId));
        categoryObj.setCategoryTitle(category.getCategoryTitle());
        categoryObj.setCategoryDescription(category.getCategoryDescription());
        return categoryRepository.save(category);
    }

    public Category getCategory(Integer categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(() ->
                new ResourceNotFoundException("Category", "category id", categoryId));
    }

    public void deleteCategory(Integer categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    public List<Category> retrieveAllCategories() {
        List<Category> categories= categoryRepository.findAll();
        System.out.println("retrieveAllCategories list size "+categories.size());
        return categories;
    }
}
