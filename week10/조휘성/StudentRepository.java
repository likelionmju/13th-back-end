package example.grade.repository;

import example.grade.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByStudentNumber(String studentNumber);
    List<Student> findByName(String name);
    List<Student> findTop3ByOrderByScoreDesc();
}
