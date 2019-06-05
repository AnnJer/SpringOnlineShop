package com.example.demo.repositories;

import com.example.demo.models.BlockList;
import org.springframework.data.repository.CrudRepository;

public interface BlockListRepos extends CrudRepository<BlockList, Long> {
}
