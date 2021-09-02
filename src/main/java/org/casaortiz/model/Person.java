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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentificationId() {
        return identificationId;
    }

    public void setIdentificationId(String identificationId) {
        this.identificationId = identificationId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getTypePersonId() {
        return typePersonId;
    }

    public void setTypePersonId(int typePersonId) {
        this.typePersonId = typePersonId;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", identificationId=" + identificationId + ", address=" + address + ", email=" + email + ", birthday=" + birthday + ", phone=" + phone + ", active=" + active + ", photo=" + photo + ", typePersonId=" + typePersonId + '}';
    }

    
}
