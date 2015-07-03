package com.luna.efrain.eshop.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Efraín on 2015-05-19.
 */
public class Category {
    private int id;
    private String name;
    private String description;
    private Set<Ad> ads = new HashSet<Ad>(0);

    public Category() {
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(int id, String name, String description, Set<Ad> ads) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ads = ads;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Ad> getAds() {
        return this.ads;
    }

    public void setAds(Set<Ad> ads) {
        this.ads = ads;
    }
}
