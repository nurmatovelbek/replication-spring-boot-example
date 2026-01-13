package uz.developers.replication.dto.response;

import lombok.Data;
import uz.developers.replication.domain.enumuration.ClassCharacter;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class GetStudentDTO {
    private UUID id;
    private String fullName;
    private String phoneNumber;
    private Class currentClass;
    private LocalDate updatedAt;
    private LocalDate createdAt;

    @Data
    public static class Class {
        private UUID id;
        private Integer number;
        private ClassCharacter character;
    }
}