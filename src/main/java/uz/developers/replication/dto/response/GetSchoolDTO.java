package uz.developers.replication.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class GetSchoolDTO {
    private UUID id;
    private String name;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
}