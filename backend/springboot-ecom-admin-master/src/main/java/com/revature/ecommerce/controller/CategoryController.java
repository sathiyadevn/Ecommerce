package com.revature.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.revature.ecommerce.entity.Category;
import com.revature.ecommerce.exception.ItemExistsException;
import com.revature.ecommerce.service.CategoryManagementService;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    CategoryManagementService productManagementService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(path = "add")
    public Category addCategory(@RequestBody Category category) throws ItemExistsException {
        return productManagementService.saveCategory(category);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(path = "update/{categoryId}")
    public Category updateCategory(@PathVariable("categoryId") int categoryId ,@RequestBody Category category) throws ItemExistsException {
        return productManagementService.updateCategory(categoryId, category);
    }

    @GetMapping(path = "getById/{categoryId}")
    public Category getCategoryById(@PathVariable("categoryId") int categoryId) throws ItemExistsException {
        return productManagementService.getCategoryById(categoryId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "delete/{categoryId}")
    public String delete(@PathVariable("categoryId") int categoryId) throws ItemExistsException {
        productManagementService.deleteCategory(categoryId);
        return "Deleted!";
    }

    @GetMapping(path = "all")
    public List<Category> getCategories(){
        return productManagementService.getCategories();
    }
}
