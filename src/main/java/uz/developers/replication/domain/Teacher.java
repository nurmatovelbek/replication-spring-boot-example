package uz.developers.replication.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Teacher extends AbstractBaseDomain {
    private String fullName;
    private String phoneNumber;

    @ManyToOne
    private School school;
}
