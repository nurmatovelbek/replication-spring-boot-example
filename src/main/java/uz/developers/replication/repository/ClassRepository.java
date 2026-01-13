package uz.developers.replication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.replication.domain.Class;

import java.util.UUID;

public interface ClassRepository extends JpaRepository<Class, UUID> {
}