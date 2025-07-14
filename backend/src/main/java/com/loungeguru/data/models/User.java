package com.loungeguru.data.models;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class User extends PanacheMongoEntity
{
    public String email;
    public String firstName;
    public String lastName;
    public String passwordHash;

    public User() {}

    public User(String email, String firstName, String lastName, String passwordHash) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passwordHash = passwordHash;
    }
}
