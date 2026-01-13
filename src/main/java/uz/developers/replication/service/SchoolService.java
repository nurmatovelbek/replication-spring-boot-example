package uz.developers.replication.service;

import org.springframework.data.domain.Page;
import uz.developers.replication.dto.request.SaveSchoolDTO;
import uz.developers.replication.dto.request.UpdateSchoolDTO;
import uz.developers.replication.dto.response.GetSchoolDTO;

import java.util.UUID;

public interface SchoolService {
    void save(SaveSchoolDTO saveSchoolDTO);

    void update(UUID id, UpdateSchoolDTO updateSchoolDTO);

    Page<GetSchoolDTO> findAll(int page, int size);
}
