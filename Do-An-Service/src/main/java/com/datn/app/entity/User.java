package com.datn.app.entity;

import com.datn.app.dto.BaseDto;
import com.datn.app.dto.UserDto;
import com.datn.app.util.AppUtil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table
public class User extends BaseEnt implements UserDetails {
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(columnDefinition = "boolean default true")
    private boolean accountNonExpired;
    @Column(columnDefinition = "boolean default true")
    private boolean AccountNonLocked;
    @Column(columnDefinition = "boolean default true")
    private boolean enabled;

    public User() { }

    @Override
    public UserDto convertToDto() {
        return AppUtil.mapToDtoAndEnt(this, UserDto.class);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add((GrantedAuthority) () -> "ADMIN");
        return grantedAuthorities;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return AccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        AccountNonLocked = accountNonLocked;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
