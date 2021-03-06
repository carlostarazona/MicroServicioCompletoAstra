package pe.edu.upc.hospitalservice.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.hospitalservice.entities.MedicalEquipment;
import pe.edu.upc.hospitalservice.repositories.MedicalEquipmentRepository;
import pe.edu.upc.hospitalservice.services.MedicalEquipmentService;


import java.util.List;
import java.util.Optional;

@Service
public class MedicalEquipmentServiceImpl implements MedicalEquipmentService {

    @Autowired
    private MedicalEquipmentRepository medicalEquipmentRepository;


    @Override
    public MedicalEquipment save(MedicalEquipment entity) throws Exception {
        return medicalEquipmentRepository.save(entity);
    }

    @Override
    public List<MedicalEquipment> findAll() throws Exception {
        return medicalEquipmentRepository.findAll();
    }

    @Override
    public Optional<MedicalEquipment> findById(Integer integer) throws Exception {
        return medicalEquipmentRepository.findById(integer);
    }

    @Override
    public MedicalEquipment actualizar(MedicalEquipment Entity) throws Exception {
        return medicalEquipmentRepository.save(Entity);
    }

    @Override
    public ResponseEntity<?> deleteById(Integer integer) throws Exception {
        medicalEquipmentRepository.deleteById(integer);
        return null;
    }
}
