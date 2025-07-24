package com.loungeguru.resources;

import com.loungeguru.data.models.User;
import com.loungeguru.data.repositories.UserRepository;
import com.loungeguru.users.LoginRequest;
import com.loungeguru.users.Tokens;
import com.loungeguru.users.UserRequest;
import com.loungeguru.users.UserService;
import io.smallrye.jwt.auth.principal.ParseException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.NewCookie;
import jakarta.ws.rs.core.Response;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Map;

@Path("/users")
public class UserResource
{
    @Inject UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(UserRequest request) {
        try
        {
            User user = userService.createUser(request.email, request.firstName, request.lastName, request.password);
            return Response.status(Response.Status.CREATED).entity(user).build();
        } catch (ForbiddenException e) {
            return Response.status(Response.Status.CONFLICT).entity("The user already exists.").build();
        }
    }

    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUser(LoginRequest request) {
        try
        {
            Tokens tokens = userService.loginUser(request.email, request.password);

            return Response.ok(tokens).build();
        } catch (NotFoundException e)
        {
            return Response.status(Response.Status.NOT_FOUND).entity("The user doesn't exist").build();
        } catch (ForbiddenException e) {
            return Response.status(Response.Status.FORBIDDEN).entity("The password is incorrect").build();
        }
    }

    @Path("/refresh")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response refresh(@CookieParam("refreshToken") String refreshToken) {
        if (refreshToken == null)
        {
            return Response.status(Response.Status.UNAUTHORIZED).entity("The refresh token wasn't found.").build();
        }

        try
        {
            Tokens tokens = userService.refreshToken(refreshToken);

            return Response.ok(tokens).build();
        } catch (ParseException e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid refresh token.").build();
        }
    }
}
