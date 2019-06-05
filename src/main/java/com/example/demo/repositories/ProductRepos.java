package com.example.demo.repositories;

import com.example.demo.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepos extends CrudRepository<Product, Long> {
}
