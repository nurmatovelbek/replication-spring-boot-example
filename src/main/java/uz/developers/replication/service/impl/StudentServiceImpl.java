package uz.developers.replication.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.developers.replication.domain.Class;
import uz.developers.replication.domain.Student;
import uz.developers.replication.dto.request.SaveStudentDTO;
import uz.developers.replication.dto.request.UpdateStudentDTO;
import uz.developers.replication.dto.response.GetStudentDTO;
import uz.developers.replication.mapper.StudentMapper;
import uz.developers.replication.repository.ClassRepository;
import uz.developers.replication.repository.StudentRepository;
import uz.developers.replication.service.StudentService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final ClassRepository classRepository;

    @Override
    public void save(SaveStudentDTO saveStudentDTO) {
        Class currentClass = classRepository.findById(saveStudentDTO.getCurrentClassId())
                .orElseThrow();

        Student student = studentMapper.toEntity(currentClass, saveStudentDTO);
        studentRepository.save(student);
    }

    @Override
    public void update(UUID id, UpdateStudentDTO updateStudentDTO) {
        studentRepository.findById(id).ifPresent(student -> {
            studentMapper.mapToUpdate(student, updateStudentDTO);
            studentRepository.save(student);
        });
    }

    @Override
    public Page<GetStudentDTO> findAll(int page, int size) {
        return studentRepository.findAll(PageRequest.of(page, size))
                .map(studentMapper::toDto);
    }
}
