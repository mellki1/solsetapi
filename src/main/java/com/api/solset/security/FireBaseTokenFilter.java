package com.api.solset.security;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class FireBaseTokenFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String authenticationHeader = request.getHeader("Authorization");

        if (authenticationHeader == null || !authenticationHeader.startsWith("Bearer "))
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,"Missing token!");

        FirebaseToken decodedToken = null;
        try {
            String token = authenticationHeader.substring(7, authenticationHeader.length());
            decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(decodedToken, token, new ArrayList<>());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            chain.doFilter(request,response);
        }
        catch (FirebaseAuthException e) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            String responseMessage = "{\"error\":\"" + e.getMessage().replace("\"", "'") + "\"}";
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(responseMessage);
            response.getWriter().flush();
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,"Error! "+e.toString());
        }

        if (decodedToken==null){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Invalid token!");
        }

    }
}