/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model Person
 *
 * @author Ing. Jorge Luis Ortiz Cáceres
 * @since 31/08/2021
 * @version 0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private int id;
    private String firstName;
    private String lastName;
    private String identificationId;
    private String address;
    private String email;
    private Date birthday;
    private String phone;
    private String active;
    private String photo;
    private int typePersonId;

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", identificationId=" + identificationId + ", address=" + address + ", email=" + email + ", birthday=" + birthday + ", phone=" + phone + ", active=" + active + ", photo=" + photo + ", typePersonId=" + typePersonId + '}';
    }

    
}
