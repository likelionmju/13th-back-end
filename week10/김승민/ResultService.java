package com.example.week10;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResultService {
    private final ResultRepository resultRepository;

    public Result save(Result result) {
        return resultRepository.save(result);
    }

    //전체 조회
    public List<Result> findAll() {
        return resultRepository.findAll();
    }

    //학생 id로 성적 조회
    public Result findById(Long id) {
        return resultRepository.findById(id).orElse(new Result());
    }

    //학생 이름을로 성적 조회
    public Result findByName(String name) {
        return resultRepository.findByName(name).orElse(new Result());
    }

    //점수 높은 순으로 3명 조회
    public List<Result> findTop3ByOrderByScoreDesc() {
        return resultRepository.findTop3ByOrderByScoreDesc();
    }

    //성적 삭제
    public void delete(Long id) {
        if (resultRepository.existsById(id)) {
            resultRepository.deleteById(id);
        }else throw new RuntimeException(id+"가 존재하지 않습니다.");

    }

    //점수 수정
    public Result update(Result request) {
        Optional<Result> optional = resultRepository.findById(request.getId());
        if (optional.isPresent()) {
            Result result = optional.get();
            result.setStudentNumber(request.getStudentNumber());
            resultRepository.save(result);
            return result;
        }else throw new RuntimeException(request.getId()+"가 존재하지 않습니다.");
    }
}
