package com.example.demo.repositories;

import com.example.demo.models.BlockList;
import com.example.demo.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepos extends CrudRepository<Category, Long> {
}
