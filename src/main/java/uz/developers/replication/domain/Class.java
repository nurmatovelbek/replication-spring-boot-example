package uz.developers.replication.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.*;
import uz.developers.replication.domain.enumuration.ClassCharacter;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Class extends AbstractBaseDomain {

    @ManyToOne
    private Teacher teacher;

    @ManyToOne
    private School school;

    private Integer number;

    @Enumerated(EnumType.STRING)
    private ClassCharacter character;
}
