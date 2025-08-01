package com.loungeguru.resources;

import com.loungeguru.airports.AirportRequest;
import com.loungeguru.airports.AirportService;
import com.loungeguru.data.models.Airport;
import com.loungeguru.data.models.User;
import com.loungeguru.users.UserRequest;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/airports")
public class AirportRessource
{
    @Inject AirportService airportService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAirportByIata(AirportRequest request) {
        try
        {
            Airport airport = airportService.getAirport(request.iata);
            return Response.status(Response.Status.FOUND).entity(airport).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity("The airport wasn't found.").build();
        }
    }
}
