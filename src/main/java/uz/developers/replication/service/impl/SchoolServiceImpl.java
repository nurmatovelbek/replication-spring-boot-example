package uz.developers.replication.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.developers.replication.domain.School;
import uz.developers.replication.dto.request.SaveSchoolDTO;
import uz.developers.replication.dto.request.UpdateSchoolDTO;
import uz.developers.replication.dto.response.GetSchoolDTO;
import uz.developers.replication.mapper.SchoolMapper;
import uz.developers.replication.repository.SchoolRepository;
import uz.developers.replication.service.SchoolService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    @Override
    public void save(SaveSchoolDTO saveSchoolDTO) {
        School school = schoolMapper.toEntity(saveSchoolDTO);
        schoolRepository.save(school);
    }

    @Override
    public void update(UUID id, UpdateSchoolDTO updateSchoolDTO) {
        schoolRepository.findById(id).ifPresent(school -> {
            schoolMapper.mapToUpdate(school, updateSchoolDTO);
            schoolRepository.save(school);
        });
    }

    @Override
    public Page<GetSchoolDTO> findAll(int page, int size) {
        return schoolRepository.findAll(PageRequest.of(page, size))
                .map(schoolMapper::toDto);
    }
}
