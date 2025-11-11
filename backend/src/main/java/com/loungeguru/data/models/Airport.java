package com.loungeguru.data.models;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

import java.util.List;

@MongoEntity(collection="Airports")
public class Airport extends PanacheMongoEntity
{
    public String iata;
    public String city;
    public String code;
    public String country;
    public String image;
    public String name;
    public List<Lounge> lounges;
    public Integer ranking;
}