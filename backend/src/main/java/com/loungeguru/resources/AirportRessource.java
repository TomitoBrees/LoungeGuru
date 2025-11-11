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

import java.util.List;

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
            return Response.status(Response.Status.OK).entity(airport).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity("The airport wasn't found.").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAirports() {
        try
        {
            List<Airport> airports = airportService.getAllAirports();
            return Response.status(Response.Status.OK).entity(airports).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity("No airport was found.").build();
        }
    }

    @Path("/popular")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPopularAirports() {
        try {
            List<Airport> popularAirports = airportService.getPopularAirports();
            return Response.status(Response.Status.OK).entity(popularAirports).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity("No popular airport was found").build();
        }
    }
}
