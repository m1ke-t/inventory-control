package com.mititch.inventoryctrl.services;

import com.mititch.inventoryctrl.dto.UserDetailsView;
import com.mititch.inventoryctrl.model.User;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Service
public interface UserService extends UserDetailsService {

    @Transactional
    UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException, BadCredentialsException;

    @Transactional
    UserDetails loadUserByCredentials(final String auth);

    @Transactional
    UserDetailsView loadDetailsByCredentials(final String auth);

    @Transactional
    List<User> listAll();
}