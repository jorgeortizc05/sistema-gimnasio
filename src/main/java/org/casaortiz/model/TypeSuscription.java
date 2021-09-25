/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Model TypeSuscription using library lombok: getter and setter automaticos
 *
 * @author Ing. Jorge Luis Ortiz Cáceres
 * @since 01/09/2021
 * @version 0.0.1
 */
@Data
public class TypeSuscription {

    private Integer id;
    private String name;
    private Integer num_days;
    private Double price;
    private String description;

    public String toString() {
        return name + " - " + description;
    }
}
