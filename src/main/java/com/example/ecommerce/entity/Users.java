package com.example.ecommerce.entity;

import jakarta.persistence.*;

@Entity//marks user as database table
@Table(name = "users") //makes sure the tbale name i susers in the db
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// this and @id ensure id is auto-genrated
    private  Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    //private String name;

    @Column(name="email_id", nullable = false, unique = true)
    private String email;

    public Users() {

    }

    public Users(String username, String password, String email) {
        //this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




}

