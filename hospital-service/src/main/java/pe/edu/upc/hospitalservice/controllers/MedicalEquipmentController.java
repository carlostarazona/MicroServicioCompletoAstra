package pe.edu.upc.hospitalservice.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.upc.hospitalservice.entities.MedicalEquipment;
import pe.edu.upc.hospitalservice.repositories.MedicalEquipmentRepository;
import pe.edu.upc.hospitalservice.services.MedicalEquipmentService;
import pe.edu.upc.hospitalservice.services.ModelService;


import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/medical_equipments")
public class MedicalEquipmentController {
    @Autowired
    private MedicalEquipmentRepository medicalEquipmentRepository;
    @Autowired
    private ModelService modelService;
    @Autowired
    private MedicalEquipmentService medicalEquipmentService;




    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MedicalEquipment> fetchById(@PathVariable("id") Integer id){
        try{
            Optional<MedicalEquipment> optionalMedicalEquipment = medicalEquipmentRepository.findById(id);
            if(optionalMedicalEquipment.isPresent()){
            return new ResponseEntity<MedicalEquipment>(optionalMedicalEquipment.get(), HttpStatus.OK);
        }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
    public ResponseEntity<List<MedicalEquipment>> findAll() {
        try {
            List<MedicalEquipment> medicalEquipments = medicalEquipmentRepository.findAll();
            if (medicalEquipments.isEmpty()) {
                return  ResponseEntity.noContent().build();
            } else{
                return  ResponseEntity.ok(medicalEquipments);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @PostMapping("/models/{id}/medical_equipments")
    public Object save(@PathVariable("id") Integer id, @RequestBody MedicalEquipment
            model, BindingResult result){
        log.info("Creating Invoice : {}", model);
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        try {

            return modelService.findById(id).map(models -> {model.setModel(models);
                return medicalEquipmentRepository.save(model);});
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<MedicalEquipment> deleteById(@PathVariable(name = "id") Integer id) {

        try {
            return (ResponseEntity<MedicalEquipment>) medicalEquipmentService.deleteById(id);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
