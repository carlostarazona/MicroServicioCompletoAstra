package pe.edu.upc.hospitalservice.services;


import pe.edu.upc.hospitalservice.entities.Model;

import java.util.Optional;

public interface ModelService extends CrudService<Model, Integer>{
    Optional<Model> findByModelName(String nameModel) throws Exception;

}
