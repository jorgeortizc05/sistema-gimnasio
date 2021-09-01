/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.model;

/**
 * Model TypeSuscription
 * @author Ing. Jorge Luis Ortiz Cáceres
 * @since 01/09/2021
 * @version 0.0.1
 */
public class TypeSuscription {
    private int id;
    private String name;
    private int num_days;
    private double price;
    private String description;

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

    public int getNum_days() {
        return num_days;
    }

    public void setNum_days(int num_days) {
        this.num_days = num_days;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TypeSuscription{" + "id=" + id + ", name=" + name + ", num_days=" + num_days + ", price=" + price + ", description=" + description + '}';
    }

    
}
