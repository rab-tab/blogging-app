package com.spring.blog.controllers;

import com.spring.blog.entities.Category;
import com.spring.blog.entities.User;
import com.spring.blog.services.CategoryService;
import com.spring.blog.services.UserService;
import com.spring.blog.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<Category> createCategory(@RequestBody Category category)
    {
        Category createdCategory=categoryService.createCategory(category);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> retrieveCategory(@PathVariable Integer category) {
        Category category1 = this.categoryService.getCategory(category);
        return new ResponseEntity<>(category1, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Category>> retrieveAllCategories() {
        List<Category> categories = this.categoryService.retrieveAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer categoryId) {
        this.categoryService.deleteCategory(categoryId);
        return new ResponseEntity(new ApiResponse("category deleted successfully", true), HttpStatus.OK);

    }
}
