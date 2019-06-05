package com.example.demo.controllers;

import com.example.demo.models.Order;
import com.example.demo.models.Product;
import com.example.demo.repositories.OrderRepos;
import com.example.demo.repositories.ProductRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepos productRepos;

    @GetMapping
    public Iterable<Product> getAll() {
        System.out.println(productRepos.findAll());
        return productRepos.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable(name = "id") Long id) throws ChangeSetPersister.NotFoundException {
        return productRepos.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestParam(name = "id") Long id){
        productRepos.deleteById(id);
    }

}
