package uz.developers.replication.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.developers.replication.domain.Class;
import uz.developers.replication.domain.School;
import uz.developers.replication.domain.Teacher;
import uz.developers.replication.dto.request.SaveClassDTO;
import uz.developers.replication.dto.request.UpdateClassDTO;
import uz.developers.replication.dto.response.GetClassDTO;
import uz.developers.replication.mapper.ClassMapper;
import uz.developers.replication.repository.ClassRepository;
import uz.developers.replication.repository.SchoolRepository;
import uz.developers.replication.repository.TeacherRepository;
import uz.developers.replication.service.ClassService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {

    private final ClassRepository classRepository;
    private final ClassMapper classMapper;
    private final TeacherRepository teacherRepository;
    private final SchoolRepository schoolRepository;

    @Override
    public void save(SaveClassDTO saveClassDTO) {

        Teacher teacher = teacherRepository.findById(saveClassDTO.getTeacherId()).orElseThrow();
        School school = schoolRepository.findById(saveClassDTO.getSchoolId()).orElseThrow();

        Class clazz = classMapper.toEntity(school, teacher, saveClassDTO);
        classRepository.save(clazz);
    }

    @Override
    public void update(UUID id, UpdateClassDTO updateClassDTO) {
        classRepository.findById(id).ifPresent(clazz -> {
            classMapper.mapToUpdate(clazz, updateClassDTO);
            classRepository.save(clazz);
        });
    }

    @Override
    public Page<GetClassDTO> findAll(int page, int size) {
        return classRepository.findAll(PageRequest.of(page, size))
                .map(classMapper::toDto);
    }
}
