package org.ifa.fbansept.Alea.security;

import com.fasterxml.jackson.annotation.JsonView;
import org.ifa.fbansept.Alea.jsonview.MyJsonView;
import org.ifa.fbansept.Alea.model.Player;
import org.ifa.fbansept.Alea.model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class MyPlayerDetails implements UserDetails {

    private String email;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;

    public MyPlayerDetails(Player player) {
        this.email = player.getEmail();
        this.password = player.getPassword();
        this.active = player.isActive();
        this.authorities = player.getRoles().stream()
                .map(Role::getNom)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    //region -- implemented methods UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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
        return active;
    }

    //endregion

    //region -- Getters and Setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
    //endregion
}
