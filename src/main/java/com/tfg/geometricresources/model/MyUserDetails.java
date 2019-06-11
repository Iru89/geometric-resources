package com.tfg.geometricresources.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;


public class MyUserDetails implements UserDetails {

    @Id
    private final ObjectId id;

    private final String username;
    private final String password;
    private final String email;
    private final List<SimpleGrantedAuthority> authorities;

    public MyUserDetails(ObjectId id, String username, String password, String email, List<SimpleGrantedAuthority> authorities) {
        this.id = id;

        this.username = username;
        this.password = password;
        this.email = email;
        this.authorities = authorities;
    }


    public ObjectId getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public List<SimpleGrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}

