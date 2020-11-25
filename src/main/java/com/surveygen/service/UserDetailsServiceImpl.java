package com.surveygen.service;

import com.surveygen.Repository.UserLoginRepository;
import com.surveygen.model.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserLoginRepository userLoginRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        UserLogin userLogin = userLoginRepository.findByUsername(username);
        if (userLogin == null) throw new UsernameNotFoundException(username);

        return new org.springframework.security.core.userdetails.User(userLogin.getUsername(), userLogin.getPassword(), new HashSet<>());
    }


}
