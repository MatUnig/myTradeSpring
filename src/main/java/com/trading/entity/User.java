package com.trading.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity

public class User {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "Name", length = 20)
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;
    @Column(name = "Surname", length = 30)
    @Size(min = 2, max = 30)
    private String surname;
    @Column(name = "Email")
    @NotBlank
    private String email;
    @Column(length = 30)
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @Column(precision = 12, scale = 2)
    private double balance = 10000;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Transaction> trans;
    private int enabled;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @Override
    public String toString() {
        return "User{" +
                "roles=" + roles +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTrans() {
        return trans;
    }

    public void setTrans(List<Transaction> trans) {
        this.trans = trans;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}