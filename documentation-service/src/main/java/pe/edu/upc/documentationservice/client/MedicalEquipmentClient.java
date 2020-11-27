package pe.edu.upc.documentationservice.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.upc.documentationservice.model.MedicalEquipment;


@FeignClient(name = "hospital-service", fallback = MedicalEquipmentHystrixFallbackFactory.class)
public interface MedicalEquipmentClient {
    @GetMapping(value = "/medical_equipments/")
    public ResponseEntity<MedicalEquipment> getMedicalEquipment(@PathVariable("id") Integer id);
}
