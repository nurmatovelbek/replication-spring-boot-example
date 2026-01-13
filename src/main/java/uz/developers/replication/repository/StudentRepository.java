package uz.developers.replication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.replication.domain.Student;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
}