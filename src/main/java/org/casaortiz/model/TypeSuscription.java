/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model TypeSuscription
 * @author Ing. Jorge Luis Ortiz Cáceres
 * @since 01/09/2021
 * @version 0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeSuscription {
    private int id;
    private String name;
    private int num_days;
    private double price;
    private String description;

    @Override
    public String toString() {
        return "TypeSuscription{" + "id=" + id + ", name=" + name + ", num_days=" + num_days + ", price=" + price + ", description=" + description + '}';
    }

    
}
