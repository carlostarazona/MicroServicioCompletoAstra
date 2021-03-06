package pe.edu.upc.documentationservice.service;


import pe.edu.upc.documentationservice.entity.ManagerRequest;

import java.util.List;
import java.util.Optional;

public interface ManagerRequestService {

    public List<ManagerRequest> findManagerRequestAll();

    public ManagerRequest createManagerRequest(ManagerRequest managerRequest);
    public ManagerRequest updateManagerRequest(ManagerRequest managerRequest);
    public ManagerRequest deleteManagerRequest(Long id);

    public Optional<ManagerRequest> getManagerRequest(Long id);
}
