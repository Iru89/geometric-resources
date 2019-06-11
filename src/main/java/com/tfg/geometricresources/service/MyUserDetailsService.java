package com.tfg.geometricresources.service;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.tfg.geometricresources.model.MyUserDetails;
import com.tfg.geometricresources.security.JwtProvider;
import org.bson.types.ObjectId;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService {


    private JwtProvider jwtProvider;

    public MyUserDetailsService(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    public UserDetails loadUser(String authToken) {
        DecodedJWT jwt = jwtProvider.decodedJWT(authToken);

        ObjectId userId = new ObjectId(jwt.getClaim("userId").asString());
        String username = jwt.getClaim("username").asString();
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        Claim authoritiesClaim = jwt.getClaim("authorities");
        authorityList = authoritiesClaim.asList(SimpleGrantedAuthority.class);

        MyUserDetails myUserDetails = new MyUserDetails(
                userId,
                username,
                "",
                jwt.getSubject(),
                authorityList);

        return myUserDetails;

    }
}
