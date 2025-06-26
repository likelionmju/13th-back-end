package hello.grademanager;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student register(Student student) {
        return studentRepository.save(student);
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(new Student());
    }

    public List<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public List<Student> findTop3ByOrderByScoreDesc() {
        return studentRepository.findTop3ByOrderByScoreDesc();
    }

    public Student update(Student student) {
        if (studentRepository.existsById(student.getId())) {
            return studentRepository.save(student);
        } else throw new RuntimeException("아이디 "+student.getId()+"의 학생이 존재하지 않습니다.");
    }

    public void deleteById(Long id) {
        if(studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        } else throw new RuntimeException("아이디 "+id+"의 학생이 존재하지 않습니다.");
    }
}
