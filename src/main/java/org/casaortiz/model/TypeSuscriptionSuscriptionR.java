package org.casaortiz.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Select Table Type Suscription and Suscription.
 * select s.id, receipt_number, date_suscription, date_from, date_to, s.price, discount, total, "comment", person_id, type_suscription_id, ts.id as id_type_sus, ts."name" as name_type_sus, ts.num_days as num_days_type_sus,ts.price price_type_sus,ts.description desciption_type_sus
from Suscription s, type_suscription ts 
where ts.id = s.type_suscription_id
 *
 * @author Ing. Jorge Luis Ortiz Cáceres
 * @since 26/11/2021
 * @version 0.0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TypeSuscriptionSuscriptionR {
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
    private Integer idTypeSus;
    private String nameTypeSus;
    private Integer num_daysTypeSus;
    private Double priceTypeSus;
    private String descriptionTypeSus;
}
