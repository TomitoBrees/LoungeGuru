package com.loungeguru.users;

import com.loungeguru.data.models.User;
import com.loungeguru.data.repositories.UserRepository;
import io.quarkus.security.UnauthorizedException;
import io.smallrye.jwt.auth.principal.JWTParser;
import io.smallrye.jwt.auth.principal.ParseException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.ForbiddenException;
import jakarta.ws.rs.NotFoundException;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.mindrot.jbcrypt.BCrypt;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Set;

import io.smallrye.jwt.build.Jwt;

@ApplicationScoped
public class UserService
{
    @Inject JWTParser jwtParser;
    @Inject UserRepository userRepository;

    public User createUser(String email, String firstName, String lastName, String password)
    {
        if (userRepository.findByUsername(email) != null) {
            throw new ForbiddenException("The user already exists");
        }

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        User user = new User(email, firstName, lastName, hashedPassword);

        userRepository.persist(user);
        return user;
    }

    public Tokens loginUser(String email, String password) {

        // Check if the user exists
        User user = userRepository.findByUsername(email);
        if (user == null) {
            throw new NotFoundException("The username is incorrect");
        }

        // Check if password is correct
        if (!BCrypt.checkpw(password, user.passwordHash)) {
            throw new ForbiddenException("Incorrect password");
        }

        // Generate the JWT tokens
        Instant now = Instant.now();
        String accessToken = Jwt.issuer("lounge-guru")
                .upn(email)
                .groups(Set.of("user"))
                .claim("firstName", user.firstName)
                .claim("lastName", user.lastName)
                .issuedAt(now)
                .expiresAt(now.plus(60, ChronoUnit.MINUTES))
                .sign();

        String refreshToken = Jwt.issuer("lounge-guru")
                .upn(email)
                .claim("firstName", user.firstName)
                .claim("lastName", user.lastName)
                .issuedAt(now)
                .expiresAt(now.plus(30, ChronoUnit.DAYS))
                .sign();

        return new Tokens(accessToken, refreshToken);
    }

    public Tokens refreshToken(String refreshToken) throws ParseException
    {
        JsonWebToken parsed = jwtParser.parse(refreshToken);

        long now = Instant.now().getEpochSecond();
        if (parsed.getExpirationTime() < now) {
            throw new UnauthorizedException("Refresh token is expired. Need to log in again.");
        }

        String email = parsed.getName();
        String firstName = parsed.getClaim("firstName");
        String lastName = parsed.getClaim("lastName");


        Instant instantNow = Instant.now();
        String newAccessToken = Jwt.issuer("lounge-guru")
                .upn(email)
                .groups(Set.of("user"))
                .claim("firstName", firstName)
                .claim("lastName", lastName)
                .issuedAt(now)
                .expiresAt(instantNow.plus(60, ChronoUnit.MINUTES))
                .sign();

        String newRefreshToken = Jwt.issuer("lounge-guru")
                .upn(email)
                .issuedAt(now)
                .expiresAt(instantNow.plus(30, ChronoUnit.DAYS))
                .sign();

        return new Tokens(newAccessToken, newRefreshToken);
    }
}
