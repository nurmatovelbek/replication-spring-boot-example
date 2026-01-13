package uz.developers.replication.service;

import org.springframework.data.domain.Page;
import uz.developers.replication.dto.request.SaveTeacherDTO;
import uz.developers.replication.dto.request.UpdateTeacherDTO;
import uz.developers.replication.dto.response.GetTeacherDTO;

import java.util.UUID;

public interface TeacherService {
    void save(SaveTeacherDTO saveTeacherDTO);

    void update(UUID id, UpdateTeacherDTO updateTeacherDTO);

    Page<GetTeacherDTO> findAll(int page, int size);
}
