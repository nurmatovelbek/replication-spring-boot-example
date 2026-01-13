package uz.developers.replication.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import uz.developers.replication.domain.Class;
import uz.developers.replication.domain.School;
import uz.developers.replication.domain.Teacher;
import uz.developers.replication.dto.request.SaveClassDTO;
import uz.developers.replication.dto.request.UpdateClassDTO;
import uz.developers.replication.dto.response.GetClassDTO;

@Mapper(componentModel = "spring")
public interface ClassMapper {
    Class toEntity(School school, Teacher teacher, SaveClassDTO saveClassDTO);

    @Mapping(target = "teacher", ignore = true)
    @Mapping(target = "school", ignore = true)
    void mapToUpdate(@MappingTarget Class clazz, UpdateClassDTO updateClassDTO);

    GetClassDTO toDto(Class aClass);
}
