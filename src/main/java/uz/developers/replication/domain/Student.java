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
public class Student extends AbstractBaseDomain {
    private String fullName;
    private String phoneNumber;

    @ManyToOne
    private Class currentClass;
}
