package com.loungeguru.data.models;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class User extends PanacheMongoEntity
{
    public String email;
    public String firstName;
    public String lastName;
    public String passwordHash;
}
