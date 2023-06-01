package fr.cgs.cgs_back.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.cgs.cgs_back.entity.User;
import fr.cgs.cgs_back.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManagerImpl;
    private String secret;
    private ApplicationContext ctx;

    public  JWTAuthenticationFilter(AuthenticationManager authenticationManagerImpl, String secret, ApplicationContext ctx) {
        this.authenticationManagerImpl = authenticationManagerImpl;
        this.secret = secret;
        this.ctx = ctx;
    }

    /**
     * Intercepte la demande d'authentification, check le body de la requête sur /login
     *
     * @param request from which to extract parameters and perform the authentication
     * @param response the response, which may be needed if the implementation has to do a
     * redirect as part of a multi-stage authentication process (such as OIDC).
     * @return
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        try {
            AccountCredentials creds = new ObjectMapper().readValue(request.getInputStream(), AccountCredentials.class);
            return getAuthentication(creds);
        } catch (IOException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }

    private Authentication getAuthentication(AccountCredentials creds) {
        try {
            return authenticationManagerImpl.authenticate(
                    new UsernamePasswordAuthenticationToken(creds.getUsername(), creds.getPassword(),
                            new ArrayList<>()));
        } catch (AuthenticationException e) {
            logger.error(e);
            throw e;
        }
    }


    @Override
    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication auth) {
        ZonedDateTime expiration = LocalDateTime.now().plusHours(12).atZone(ZoneId.of("Europe/Paris"));

        UserRepository userRepository = ctx.getBean(UserRepository.class);

        UserDetails principal = (UserDetails) auth.getPrincipal();
        logger.info("successfulAuthentication -> Login of USER ${principal.username}");

        User byEmail = userRepository.findByEmail(principal.getUsername()).get();

        String token = Jwts.builder()
                .setSubject(byEmail.getEmail())
                .claim("auth", byEmail.getRole().name())
                .setExpiration(Date.from(expiration.toInstant()))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()), SignatureAlgorithm.HS256)
                .compact();
        byEmail.setToken(token);
        userRepository.save(byEmail);
        response.setHeader(HttpHeaders.AUTHORIZATION, "Baerer " + token);
    }
}
