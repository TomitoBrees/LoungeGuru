package com.loungeguru.airports;

import com.loungeguru.data.models.Airport;
import com.loungeguru.data.repositories.AirportRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

@ApplicationScoped
public class AirportService
{
    @Inject AirportRepository airportRepository;

    public Airport getAirport(String iata)
    {
        Airport airport = airportRepository.findByIATA(iata);
        if (airport != null)
        {
            return airport;
        }
        else
        {
            throw new NotFoundException("The airport with the given IATA code wasn't found");
        }
    }

    public Airport[] getAllAirports()
    {
        Airport[] airports = airportRepository.listAll().toArray(new Airport[0]);
        if (airports.length > 0)
        {
            return airports;
        }
        else
        {
            throw new NotFoundException("No airport was found");
        }
    }
}
