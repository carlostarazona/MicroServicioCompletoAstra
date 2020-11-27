package pe.edu.upc.documentationservice.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import pe.edu.upc.documentationservice.model.MedicalEquipment;


@Component
public class MedicalEquipmentHystrixFallbackFactory implements MedicalEquipmentClient {
    @Override
    public ResponseEntity<MedicalEquipment> getMedicalEquipment(Integer id) {
        MedicalEquipment medicalEquipment = MedicalEquipment.builder()
                .id(null)
                .descriptionStatus("none")
                .createAt(null)
                .status("none")
                .id_model(null).build();
        return ResponseEntity.ok(medicalEquipment);
    }
}