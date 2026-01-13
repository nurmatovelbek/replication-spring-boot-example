package uz.developers.replication.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import uz.developers.replication.domain.Class;
import uz.developers.replication.domain.Student;
import uz.developers.replication.dto.request.SaveStudentDTO;
import uz.developers.replication.dto.request.UpdateStudentDTO;
import uz.developers.replication.dto.response.GetStudentDTO;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toEntity(Class currentClass, SaveStudentDTO saveStudentDTO);

    @Mapping(target = "currentClass", ignore = true)
    void mapToUpdate(@MappingTarget Student student, UpdateStudentDTO updateStudentDTO);

    GetStudentDTO toDto(Student student);
}
