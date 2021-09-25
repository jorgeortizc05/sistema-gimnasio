package org.casaortiz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Model TypeVoucher
 * @author Ing. Jorge Luis Ortiz Cáceres
 * @since 31/08/2021
 * @version 0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TypeVoucher {
    private Integer id;
    private String name;
    private String description;
}