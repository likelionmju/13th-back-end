package com.example.week10_hw.service;

import com.example.week10_hw.domain.Student;
import com.example.week10_hw.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    //save
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    //전체조회
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    //id로 조회
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    //이름으로 조회
    public List<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }

    //점수 높은 3명 조회
    public List<Student> getTop3() {
        return studentRepository.findTop3ByOrderByScoreDesc();
    }

    //delete
    public void delete(Long id) {
        //id가 존재하는지 확인
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        } else throw new RuntimeException(id + "가 존재하지 않습니다.");
    }

    //update
    public Student update(Student request) {
        Optional<Student> optional = studentRepository.findById(request.getId());

        if (optional.isPresent()) {
            Student student = optional.get();
            //점수만 수정
            student.setScore(request.getScore());

            // 수정된 객체 저장
            return studentRepository.save(student);
        } else {
            throw new RuntimeException("해당 ID의 학생이 존재하지 않습니다.");
        }
    }



}
