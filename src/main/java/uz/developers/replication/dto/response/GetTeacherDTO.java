package uz.developers.replication.dto.response;

import jakarta.persistence.ManyToOne;
import lombok.Data;
import uz.developers.replication.domain.School;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class GetTeacherDTO {
    private UUID id;
    private String fullName;
    private String phoneNumber;
    private School school;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

    @Data
    public static class School {
        private UUID id;
        private String name;

    }
}