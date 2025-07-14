package com.loungeguru.data.repositories;

import com.loungeguru.data.models.User;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheMongoRepository<User>
{
    public User findByUsername(String email) {
        return find("email", email).firstResult();
    }
}
