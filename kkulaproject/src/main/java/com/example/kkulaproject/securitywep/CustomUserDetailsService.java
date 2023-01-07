package com.example.kkulaproject.securitywep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.kkulaproject.datacalss.User;
import com.example.kkulaproject.datacalss.UserRepository;


public class CustomUserDetailsService implements UserDetailsService{
    @Autowired private UserRepository repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User User = repo.findByEmail(username);
        if (User==null){
            throw new UsernameNotFoundException("No user found for the given email");
        }
        return new CustomUserDetails(User);
    }
}
