package com.mititch.inventoryctrl.services;

import com.mititch.inventoryctrl.dao.jpa.UserDao;
import com.mititch.inventoryctrl.dto.UserDetailsView;
import com.mititch.inventoryctrl.model.Roles;
import com.mititch.inventoryctrl.model.User;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.Charset;
import java.util.*;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Qualifier("userDetailsMapperFacade")
    @Autowired
    MapperFacade mapperFacade;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        User user = userDao.findUser(username);
        log.info("User: {}", user);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());
        return buildUserForAuthentication(user, authorities);
    }

    private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), !user.isDisabled(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<Roles> userRoles) {
        Set<GrantedAuthority> setAuths = new HashSet<>();

        for (Roles userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority("ROLE_" + userRole.name()));
        }
        return new ArrayList<>(setAuths);
    }

    public UserDetails loadUserByCredentials(String auth) throws BadCredentialsException {
        if (auth != null && auth.startsWith("Basic")) {
            String base64Credentials = auth.substring("Basic".length()).trim();
            String credentials = new String(Base64.getDecoder().decode(base64Credentials),
                    Charset.forName("UTF-8"));
            final String[] values = credentials.split(":", 2);

            User user = userDao.findUser(values[0]);

            log.info("User: {}", user);
            if (!passwordEncoder.matches(values[1], user.getPassword()))
                log.info("Wrong password: {} for User: {}", values[1], user.getLogin());
            List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());

            return buildUserForAuthentication(user, authorities);
        } else throw new BadCredentialsException("Basic authorization required");
    }

    public UserDetailsView loadDetailsByCredentials(String auth) {
        UserDetails userDetails = loadUserByCredentials(auth);
        UserDetailsView details = mapperFacade.map(userDetails, UserDetailsView.class);
        details.setAuthorities(new ArrayList<>(userDetails.getAuthorities()));

        return details;
    }

    public List<User> listAll() {
        return userDao.findAll();
    }
}

