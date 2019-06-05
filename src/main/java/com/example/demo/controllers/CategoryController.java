package com.example.demo.controllers;


import com.example.demo.models.BlockList;
import com.example.demo.models.Category;
import com.example.demo.models.User;
import com.example.demo.repositories.CategoryRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryRepos categoryRepos;

    @GetMapping
    public Iterable<Category> getAll() {
        return categoryRepos.findAll();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable(name = "id") Long id) throws ChangeSetPersister.NotFoundException {
        return categoryRepos.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestAttribute(name = "id") Long id){
        categoryRepos.deleteById(id);
    }
    @PostMapping
    public void insert(@RequestParam(name = "name") String name){
        categoryRepos.save(new Category(name));
    }
}
