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
import lombok.ToString;

/**
 *
 * @author jorge
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Suscription {
    
    private Integer id;
    private String receipt_number;
    private Date DateSuscription;
    private Date DateFrom;
    private Date DateTo;
    private Double price;
    private Double discount;
    private Double total;
    private String comment;
    private Integer personId;
    private Integer typeSuscriptionId;
    
}
