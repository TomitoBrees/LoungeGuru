package com.loungeguru;

import com.loungeguru.data.models.User;
import com.loungeguru.data.repositories.UserRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
public class ExampleResource
{

    @Inject UserRepository userRepository;

    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello()
    {
        return "Hello from Quarkus REST";
    }

    @POST
    @Path("users")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {
        userRepository.persist(user);
        return Response.status(Response.Status.CREATED).entity(user).build();
    }
}
