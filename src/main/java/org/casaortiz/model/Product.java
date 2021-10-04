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
 * Model Category
 * @author Ing. Jorge Luis Ortiz Cáceres
 * @since 31/08/2021
 * @version 0.0.1
 */

@Data
@AllArgsConstructor
@NoArgsConstructor //sin constructor
@ToString
public class Product {

    private Integer id;
    private String name;
    private String description;
    private Double price;
    private String serial;
    private String photo;
    private Integer categoryId;




}