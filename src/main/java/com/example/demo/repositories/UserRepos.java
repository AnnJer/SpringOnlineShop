package com.example.demo.repositories;

import com.example.demo.models.Session;
import com.example.demo.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepos extends CrudRepository<User, Long> {

//    User findByEmailAndPassword(User user);

}
