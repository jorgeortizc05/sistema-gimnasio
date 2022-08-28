package org.casaortiz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Model Category
 * @author Ing. Jorge Luis Ortiz Cáceres
 * @since 28/08/2022
 * @version 0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Notes {
    private Integer id;
    private String name;
}
