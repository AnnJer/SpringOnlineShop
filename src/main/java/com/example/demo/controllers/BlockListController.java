package com.example.demo.controllers;


import com.example.demo.models.BlockList;
import com.example.demo.models.User;
import com.example.demo.repositories.BlockListRepos;
import com.example.demo.repositories.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blocklist")
public class BlockListController {

    @Autowired
    private BlockListRepos blockListRepos;

    @Autowired
    private UserRepos userRepos;

    @GetMapping
    public Iterable<BlockList> getAll() {
        return blockListRepos.findAll();
    }

    @GetMapping("/{id}")
    public BlockList getById(@PathVariable(name = "id") Long id) throws ChangeSetPersister.NotFoundException {
        return blockListRepos.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @DeleteMapping
    public void delete(@RequestParam(name = "id") Long id){
         blockListRepos.deleteById(id);
    }

    @PostMapping
    public void insert(@RequestParam(name = "user_id") Long id){
        blockListRepos.save(new BlockList(userRepos.findById(id).get(), null));
    }






}
