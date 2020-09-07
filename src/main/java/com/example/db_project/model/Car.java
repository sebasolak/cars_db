package com.example.db_project.model;

import javax.persistence.*;

@Entity
@Table
public class Car {

    public Car() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String make;
    @Column
    private String model;
    @Column
    private String color;
    @Column
    private Integer year;
    @ManyToOne(cascade = CascadeType.ALL)
    private Owner owner;

    public Car(String make, String model, String color, Integer year, Owner owner) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
