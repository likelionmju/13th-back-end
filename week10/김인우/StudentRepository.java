package hello.grademanager;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    // 이름으로 조회
    List<Student> findByName(String name);
    // 점수 높은 순으로 3명 조회
    List<Student> findTop3ByOrderByScoreDesc();
}

