package uz.developers.replication.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import uz.developers.replication.domain.School;
import uz.developers.replication.dto.request.SaveSchoolDTO;
import uz.developers.replication.dto.request.UpdateSchoolDTO;
import uz.developers.replication.dto.response.GetSchoolDTO;

@Mapper(componentModel = "spring")
public interface SchoolMapper {
    School toEntity(SaveSchoolDTO saveSchoolDTO);

    void mapToUpdate(@MappingTarget School school, UpdateSchoolDTO updateSchoolDTO);

    GetSchoolDTO toDto(School school);
}
