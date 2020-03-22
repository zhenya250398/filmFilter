package com.example.sweater.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private Integer year;
    private String name;

    public Movie() {
    }

    public Movie(Integer year, String name) {
        this.year = year;
        this.name = name;
    }

    public void setyear(Integer year) {
        this.year = year;
    }

    public Integer getyear() {
        return year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }
}
