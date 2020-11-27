package pe.edu.upc.managementhservice.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.managementhservice.entities.Hospital;
import pe.edu.upc.managementhservice.repositories.HospitalRepository;
import pe.edu.upc.managementhservice.services.HospitalService;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalImpl implements HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;


    @Override
    public Hospital save(Hospital entity) throws Exception {
        return hospitalRepository.save(entity);
    }

    @Override
    public List<Hospital> findAll() throws Exception {
        return hospitalRepository.findAll();
    }

    @Override
    public Optional<Hospital> findById(Integer integer) throws Exception {
        return hospitalRepository.findById(integer);
    }

    @Override
    public Hospital actualizar(Hospital Entity) throws Exception {
        return hospitalRepository.save(Entity);
    }

    @Override
    public ResponseEntity<?> deleteById(Integer integer) throws Exception {
        hospitalRepository.deleteById(integer);
        return null;
    }


}
