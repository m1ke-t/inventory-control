package com.mititch.inventoryctrl.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Set;

@Getter
@Setter


public class UserDetailsView {
    private String username;
    private boolean isEnabled;
    private ArrayList<? extends GrantedAuthority> authorities;


    private Long id;
    private String description;
    private boolean disabled;
    private Set<String> roles;
}
