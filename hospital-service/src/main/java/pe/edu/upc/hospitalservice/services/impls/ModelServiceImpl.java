package pe.edu.upc.hospitalservice.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import pe.edu.upc.hospitalservice.entities.Model;
import pe.edu.upc.hospitalservice.repositories.BrandRepository;
import pe.edu.upc.hospitalservice.repositories.ModelRepository;
import pe.edu.upc.hospitalservice.services.ModelService;


import java.util.List;
import java.util.Optional;

@Service
public class ModelServiceImpl implements ModelService {
    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Model save(Model entity) throws Exception {

        return modelRepository.save(entity);
    }

    @Override
    public List<Model> findAll() throws Exception {
        return modelRepository.findAll();
    }

    @Override
    public Optional<Model> findById(Integer integer) throws Exception {
        return modelRepository.findById(integer);
    }

    @Override
    public Model actualizar(Model Entity) throws Exception {
        return modelRepository.save(Entity);
    }

    @Override
    public ResponseEntity<?> deleteById(Integer integer) throws Exception {
        modelRepository.deleteById(integer);
        return null;
    }

    @Override
    public Optional<Model> findByModelName(String nameModel) throws Exception {
        return modelRepository.findByModelName(nameModel);
    }



}
