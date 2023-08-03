package com.sparta.springlv2.security;

import com.sparta.springlv2.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {

    private final User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }


    public User getUser() {
        return this.user;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        // 사용자의 권한을 "ROLE_" 접두사와 함께 추가합니다.
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        // 다른 권한이 필요한 경우 위와 같이 추가합니다.
        // authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        // authorities.add(new SimpleGrantedAuthority("ROLE_MODERATOR"));
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