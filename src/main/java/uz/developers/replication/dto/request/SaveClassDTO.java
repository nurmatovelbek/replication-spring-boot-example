package uz.developers.replication.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import uz.developers.replication.domain.enumuration.ClassCharacter;

import java.util.UUID;

@Data
public class SaveClassDTO {
    @NotNull
    private UUID teacherId;

    @NotNull
    private UUID schoolId;

    @NotNull
    @Min(1)
    @Max(11)
    private Integer number;

    @NotNull
    private ClassCharacter character;
}