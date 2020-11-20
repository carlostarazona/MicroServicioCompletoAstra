package Service.Management.Service.Management.services.impls;

import Service.Management.Service.Management.entities.Hospital;
import Service.Management.Service.Management.repositories.HospitalRepository;
import Service.Management.Service.Management.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
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
