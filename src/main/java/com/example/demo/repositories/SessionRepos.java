package com.example.demo.repositories;

import com.example.demo.models.Session;
import org.springframework.data.repository.CrudRepository;

public interface SessionRepos extends CrudRepository<Session, Long> {
}
