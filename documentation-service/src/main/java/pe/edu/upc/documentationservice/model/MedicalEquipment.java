package pe.edu.upc.documentationservice.model;


import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class MedicalEquipment {

    private Integer id;
    private String descriptionStatus;
    private Date createAt;
    private String status;
    private Integer id_model;
}
