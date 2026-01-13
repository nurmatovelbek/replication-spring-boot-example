package uz.developers.replication.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.developers.replication.domain.School;
import uz.developers.replication.domain.Teacher;
import uz.developers.replication.dto.request.SaveTeacherDTO;
import uz.developers.replication.dto.request.UpdateTeacherDTO;
import uz.developers.replication.dto.response.GetTeacherDTO;
import uz.developers.replication.mapper.TeacherMapper;
import uz.developers.replication.repository.SchoolRepository;
import uz.developers.replication.repository.TeacherRepository;
import uz.developers.replication.service.TeacherService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    private final SchoolRepository schoolRepository;

    @Override
    public void save(SaveTeacherDTO saveTeacherDTO) {
        School school = schoolRepository.findById(saveTeacherDTO.getSchoolId()).orElseThrow();

        Teacher teacher = teacherMapper.toEntity(school, saveTeacherDTO);
        teacherRepository.save(teacher);
    }

    @Override
    public void update(UUID id, UpdateTeacherDTO updateTeacherDTO) {
        teacherRepository.findById(id).ifPresent(teacher -> {
            teacherMapper.mapToUpdate(teacher, updateTeacherDTO);
            teacherRepository.save(teacher);
        });
    }

    @Override
    public Page<GetTeacherDTO> findAll(int page, int size) {
        return teacherRepository.findAll(PageRequest.of(page, size))
                .map(teacherMapper::toDto);
    }
}
