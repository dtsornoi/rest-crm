package com.employee.crm.service;

import com.employee.crm.entity.User;
import com.employee.crm.persistance.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDAO.findByUsername(s);

        if  (user == null){
            throw new UsernameNotFoundException(s);
        }

        List<SimpleGrantedAuthority> grantedAuthorityList = Arrays.stream(user.getAuthorities())
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getUserPassword(),
                grantedAuthorityList
        );
    }
}
