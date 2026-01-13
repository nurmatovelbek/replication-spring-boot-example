package uz.developers.replication.service;

import org.springframework.data.domain.Page;
import uz.developers.replication.dto.request.SaveStudentDTO;
import uz.developers.replication.dto.request.UpdateStudentDTO;
import uz.developers.replication.dto.response.GetStudentDTO;

import java.util.UUID;

public interface StudentService {
    void save(SaveStudentDTO saveStudentDTO);

    void update(UUID id, UpdateStudentDTO updateStudentDTO);

    Page<GetStudentDTO> findAll(int page, int size);
}
