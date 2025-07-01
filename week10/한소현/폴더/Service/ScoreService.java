package com.example.demo.Service;

import com.example.demo.Model.StudentScore;
import com.example.demo.Repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreRepository repository;

    public StudentScore save(StudentScore studentScore) {
        return repository.save(studentScore);
    }

    public List<StudentScore> findAll(){
        return repository.findAll();
    }

    public StudentScore findById(Long id){
        Optional<StudentScore> optional = repository.findById(id);
        if(optional.isEmpty()){
            return optional.get();
        }else throw new RuntimeException(id + "가 존재하지 않습니다.");
    }

    public StudentScore findByName(String name){
        Optional<StudentScore> optional = repository.findByName(name);
        if(optional.isEmpty()){
            return optional.get();
        }else throw new RuntimeException(name + "가 존재하지 않습니다.");
    }

    public List<StudentScore> findTop3ByOrderByScore(){
        return repository.findTop3ByOrderByScore();
    }

    public StudentScore update(StudentScore studentScore){
        Optional<StudentScore> optional = repository.findById(studentScore.getStudentId());
        if(optional.isPresent()){
            StudentScore score = optional.get();
            score.setScore(studentScore.getScore());
            return repository.save(score);
        }else throw new RuntimeException(studentScore.getStudentId()+"가 존재하지 않습니다.");
    }

    public void delete(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        } else throw new RuntimeException(id + "가 존재하지 않습니다.");
    }
}
