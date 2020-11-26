package pe.edu.upc.servicemanagement.entities;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "hospital")
@Data
@Getter
@Setter

public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "hospital_direccion", length = 180, nullable = false)
    private String direccionHospital;


    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(length = 1, nullable = false)
    private String status;
}
