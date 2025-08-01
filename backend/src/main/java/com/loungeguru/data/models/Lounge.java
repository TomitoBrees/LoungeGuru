package com.loungeguru.data.models;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

import java.util.List;

public class Lounge
{
    public String name;
    public String terminal;
    public String securityType;
    public String imageUrl;
    public String location;
    public String rule;
    public String price;
    public List<String> facilities;
}
