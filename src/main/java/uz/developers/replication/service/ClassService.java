package uz.developers.replication.service;

import org.springframework.data.domain.Page;
import uz.developers.replication.dto.request.SaveClassDTO;
import uz.developers.replication.dto.request.UpdateClassDTO;
import uz.developers.replication.dto.response.GetClassDTO;

import java.util.UUID;

public interface ClassService {
    void save(SaveClassDTO saveClassDTO);

    void update(UUID id, UpdateClassDTO updateClassDTO);

    Page<GetClassDTO> findAll(int page, int size);
}
