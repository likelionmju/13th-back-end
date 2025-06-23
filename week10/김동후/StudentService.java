package com.example.week10assignment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(new Student());
    }

    public Student findByName(String name) {
        return studentRepository.findByName(name).orElse(new Student());
    }

    public List<Student> findTop3() {
        return studentRepository.findTop3ByOrderByScoreDesc();
    }

    public void delete(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        } else {
            throw new RuntimeException("해당 ID는 존재하지 않습니다: " + id);
        }
    }

    public Student updateScore(Long id, int newScore) {
        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isPresent()) {
            Student student = optional.get();
            student.setScore(newScore);
            return studentRepository.save(student);
        } else {
            throw new RuntimeException("해당 ID는 존재하지 않습니다: " + id);
        }
    }
}
