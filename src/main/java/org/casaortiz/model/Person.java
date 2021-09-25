/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.model;

import java.util.Date;
/**
 * Model Person
 *
 * @author Ing. Jorge Luis Ortiz Cáceres
 * @since 31/08/2021
 * @version 0.0.1
 */
public record Person (Integer id, String firstName, String lastName, String identificationId,
        String address,String email,Date birthday,String phone,String active,String photo, Integer typePersonId) {
    
    public Person(String firstName, String lastName, String identificationId,
        String address,String email,Date birthday,String phone,String active,String photo, Integer typePersonId){
        this(null, firstName, lastName, identificationId, address, email, birthday, phone, active, photo, typePersonId);
        
    }
}
