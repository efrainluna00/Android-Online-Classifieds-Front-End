package com.luna.efrain.eshop.model;

import com.luna.efrain.eshop.util.Point;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Efraín on 2015-05-19.
 */
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String email;
    private String telephone;
    private Point location;
    private String status;
    private Set<Ad> ads = new HashSet<Ad>(0);

    public User() {
    }

    public User(int id, String firstName, String lastName, String login,
                String password, String email, String telephone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.telephone = telephone;
    }

    public User(int id, String firstName, String lastName, String login,
                String password, String email, String telephone,
                Point location, String status, Set<Ad> ads) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.telephone = telephone;
        this.location = location;
        this.status = status;
        this.ads = ads;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public Point getLocation() {
        return this.location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }


    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Ad> getAds() {
        return this.ads;
    }

    public void setAds(Set<Ad> ads) {
        this.ads = ads;
    }

}
