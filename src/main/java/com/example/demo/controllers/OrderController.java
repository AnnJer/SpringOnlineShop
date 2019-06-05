package com.example.demo.controllers;


import com.example.demo.models.BlockList;
import com.example.demo.models.Order;
import com.example.demo.models.User;
import com.example.demo.repositories.OrderRepos;
import com.example.demo.repositories.ProductRepos;
import com.example.demo.repositories.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepos orderRepos;

    @Autowired
    private UserRepos userRepos;

    @Autowired
    private ProductRepos productRepos;

    @GetMapping
    public Iterable<Order> getAll() {
        return orderRepos.findAll();
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable(name = "id") Long id) throws ChangeSetPersister.NotFoundException {
        return orderRepos.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @PostMapping("/{id}")
    public void upadate(@PathVariable(name = "id") Long id) throws ChangeSetPersister.NotFoundException {

        Order order = orderRepos.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        order.setPayed(1);
        orderRepos.save(order);
    }
    @PostMapping
    public void insert(@RequestParam(name = "client_id") Long client_id,
                       @RequestParam(name = "product_id") Long product_id,
                       @RequestParam(name = "amount") Long amount){


        orderRepos.save(new Order(userRepos.findById(client_id).get(),
                productRepos.findById(product_id).get(), amount, null));
    }

}
