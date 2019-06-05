package com.example.demo.repositories;

import com.example.demo.models.Category;
import com.example.demo.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepos extends CrudRepository<Order, Long> {
}
