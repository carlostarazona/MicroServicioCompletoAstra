package pe.edu.upc.hospitalservice.services;


import pe.edu.upc.hospitalservice.entities.Brand;

import java.util.Optional;

public interface BrandService extends CrudService<Brand, Integer>{
    Optional<Brand> findByBrandName(String nameBrand) throws Exception;

}
