package com.mititch.inventoryctrl.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    private Long id;
    private String login;
    private String password;
    private String description;
    private boolean disabled;
    @Convert(converter = RolesConverter.class)
    private Set<Roles> roles;

    public User() {
    }

    public User(String login, String password, String description) {
        this.login = login;
        this.password = password;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "disabled")
    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    @Convert(converter = RolesConverter.class)
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role_id")
    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Roles... roles) {
        this.roles = new HashSet<Roles>(Arrays.asList(roles));
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + "****" + '\'' +
                ", description='" + description + '\'' +
                ", disabled=" + disabled +
                "'}@" + Integer.toHexString(hashCode());
    }
}
