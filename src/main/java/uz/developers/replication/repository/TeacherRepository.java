package uz.developers.replication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.replication.domain.Teacher;

import java.util.UUID;

public interface TeacherRepository extends JpaRepository<Teacher, UUID> {
}