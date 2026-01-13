package uz.developers.replication.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import uz.developers.replication.domain.School;
import uz.developers.replication.domain.Teacher;
import uz.developers.replication.dto.request.SaveTeacherDTO;
import uz.developers.replication.dto.request.UpdateTeacherDTO;
import uz.developers.replication.dto.response.GetTeacherDTO;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    Teacher toEntity(School school, SaveTeacherDTO saveTeacherDTO);

    @Mapping(target = "school", ignore = true)
    void mapToUpdate(@MappingTarget Teacher teacher, UpdateTeacherDTO updateTeacherDTO);

    GetTeacherDTO toDto(Teacher teacher);
}
