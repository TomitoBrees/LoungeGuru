package com.loungeguru.data.repositories;

import com.loungeguru.data.models.Airport;
import com.loungeguru.data.models.User;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AirportRepository implements PanacheMongoRepository<Airport>
{
    public Airport findByIATA(String iata) {
        return find("iata", iata).firstResult();
    }
}
