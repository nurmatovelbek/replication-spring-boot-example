package uz.developers.replication.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class UpdateTeacherDTO {
    @NotNull
    private String fullName;

    @NotNull
    private String phoneNumber;

    @NotNull
    private UUID schoolId;
}