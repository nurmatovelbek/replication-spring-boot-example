package uz.developers.replication.domain;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class School extends AbstractBaseDomain{
    private String name;
}
