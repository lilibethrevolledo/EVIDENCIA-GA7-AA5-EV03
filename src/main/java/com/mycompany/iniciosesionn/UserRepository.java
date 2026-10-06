package com.mycompany.iniciosesion.repository;

import com.mycompany.iniciosesion.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsernameAndPassword(String username, String password);
}

