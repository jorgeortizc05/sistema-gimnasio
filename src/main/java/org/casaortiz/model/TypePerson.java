/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.model;

/**
 * Model Type Person
 *
 * @author Ing. Jorge Luis Ortiz Cáceres
 * @since 31/08/2021
 * @version 0.0.1
 */
public record TypePerson(Integer id, String name, String description) {

    public TypePerson(String name, String description) {
        this(null, name, description);
    }
}
