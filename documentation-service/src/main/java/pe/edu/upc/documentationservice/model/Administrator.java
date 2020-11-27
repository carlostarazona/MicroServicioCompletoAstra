package pe.edu.upc.documentationservice.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Administrator {

    protected Long id;
    private Date createdAt;
    private Date updatedAt;
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String dni;
}
