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
 * Model Type Person
 * @author Ing. Jorge Luis Ortiz Cáceres
 * @since 31/08/2021
 * @version 0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypePerson {
    private int id;
    private String name;
    private String description;

    @Override
    public String toString() {
        return "TypePerson{" + "id=" + id + ", name=" + name + ", description=" + description + '}';
    }
}
