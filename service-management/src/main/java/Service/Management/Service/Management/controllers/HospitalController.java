package Service.Management.Service.Management.controllers;


import Service.Management.Service.Management.entities.Hospital;
import Service.Management.Service.Management.repositories.HospitalRepository;
import Service.Management.Service.Management.services.HospitalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/hospitals")
public class HospitalController {

    @Autowired
    private HospitalRepository hospitalService;

//GET BY ID
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Hospital> fetchById(@PathVariable("id") Integer id){
        try{
            Optional<Hospital> optionalHospital = hospitalService.findById(id);
            if(optionalHospital.isPresent()){
                return new ResponseEntity<Hospital>(optionalHospital.get(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //OBTENER TODOS LOS HOSPITALES
    @GetMapping
    public ResponseEntity<List<Hospital>> findAll() {
        try {
            List<Hospital> hospitals = hospitalService.findAll();
            if (hospitals.isEmpty()) {
                return  ResponseEntity.noContent().build();
            } else{
                return  ResponseEntity.ok(hospitals);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    // CREAR UNA Hospital
    @PostMapping
    public ResponseEntity<Hospital> save(@RequestBody Hospital hospital, BindingResult result) {
        log.info("Creating Invoice : {}", hospital);
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        try {
            Hospital hospitalDB = hospitalService.save (hospital);
            return ResponseEntity.status(HttpStatus.CREATED).body(hospitalDB);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }




}
