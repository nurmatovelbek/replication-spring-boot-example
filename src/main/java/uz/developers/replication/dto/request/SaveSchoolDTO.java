package uz.developers.replication.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SaveSchoolDTO {
    @NotNull
    private String name;
}
