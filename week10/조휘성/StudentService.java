package example.grade.service;

import example.grade.domain.Student;
import example.grade.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public Student save(Student student) {
        return repository.save(student);
    }

    public List<Student> findAll() {
        return repository.findAll();
    }

    public Optional<Student> findByStudentNumber(String studentNumber) {
        return repository.findByStudentNumber(studentNumber);
    }

    public List<Student> findByName(String name) {
        return repository.findByName(name);
    }

    public List<Student> findTop3ByScore() {
        return repository.findTop3ByOrderByScoreDesc();
    }

    public Optional<Student> updateScore(Long id, int newScore) {
        return repository.findById(id).map(s -> {
            s.setScore(newScore);
            return repository.save(s);
        });
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
