package org.vafin.bookshelfapp.model;

import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {
    private final User user;


    public UserPrincipal(User user) {
        this.user = user;
    }

    @Override
    @NonNull
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(user.getRole().name()));
    }

    @Override
    @NonNull
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    @NonNull
    public String getUsername() {
        return this.user.getEmail();
    }

}
