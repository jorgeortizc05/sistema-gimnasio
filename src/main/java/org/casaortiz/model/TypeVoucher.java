package org.casaortiz.model;

/**
 * Model TypeVoucher
 *
 * @author Ing. Jorge Luis Ortiz Cáceres
 * @since 31/08/2021
 * @version 0.0.1
 */
public record TypeVoucher(Integer id, String name, String description) {

    public TypeVoucher(String name, String description) {
        this(null, name, description);
    }
}
