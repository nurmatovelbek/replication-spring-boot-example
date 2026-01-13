package uz.developers.replication.dto.response;

import lombok.Data;
import uz.developers.replication.domain.enumuration.ClassCharacter;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class GetClassDTO {
    private UUID id;
    private Teacher teacher;
    private School school;
    private Integer number;
    private ClassCharacter character;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

    @Data
    public static class School {
        private UUID id;
        private String name;

    }

    @Data
    public static class Teacher {
        private UUID id;
        private String fullName;
        private String phoneNumber;
    }
}