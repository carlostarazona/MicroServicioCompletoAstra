package Service.Management.Service.Management.entities;


import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;


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
