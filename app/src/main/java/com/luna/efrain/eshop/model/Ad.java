package com.luna.efrain.eshop.model;

import com.luna.efrain.eshop.util.Point;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Efraín on 2015-05-15.
 */
public class Ad {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String stringThumbnail;
    private String stringImage;
    private String name;
    private String description;
    private double cost;
    private String status;
    private Date postingDate;
    private Integer views;
    private Double lati;
    private Double longi;
    private Collection<Category> categoryCollection;
    private User idUser;

    public Ad() {
    }

    public Ad(int id, String stringThumbnail, String stringImage, String name,
              String description, double cost, String status, Date postingDate, Integer views,
              double lati, double longi, Collection<Category> categoryCollecction, User idUser) {
        this.id = id;
        this.stringThumbnail = stringThumbnail;
        this.stringImage = stringImage;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.status = status;
        this.postingDate = postingDate;
        this.views=views;
        this.lati=lati;
        this.longi=longi;
        this.categoryCollection=categoryCollecction;
        this.idUser=idUser;
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStringThumbnail() {
        return stringThumbnail;
    }

    public void setStringThumbnail(String stringThumbnail) {
        this.stringThumbnail = stringThumbnail;
    }

    public String getStringImage() {
        return stringImage;
    }

    public void setStringImage(String stringImage) {
        this.stringImage = stringImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Double getLati() {
        return lati;
    }

    public void setLati(Double lati) {
        this.lati = lati;
    }

    public Double getLongi() {
        return longi;
    }

    public void setLongi(Double longi) {
        this.longi = longi;
    }

    public Collection<Category> getCategoryCollection() {
        return categoryCollection;
    }

    public void setCategoryCollection(Collection<Category> categoryCollection) {
        this.categoryCollection = categoryCollection;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }







}
