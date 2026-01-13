package uz.developers.replication.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateSchoolDTO {
    @NotNull
    private String name;
}
