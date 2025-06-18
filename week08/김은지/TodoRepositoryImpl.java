package com.example.week08.repository;

import com.example.week08.domain.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoRepositoryImpl implements TodoRepository {
    //store:todo들 저장소
    private final List<Todo> store = new ArrayList<>();
    //저장 (이름,완료여부,todo내용, 등록날짜 저장)
    public void save(Todo todo) {
        store.add(todo);
    }
    //전체조회 -> 그냥 저장소인 store를 리턴해주면 됨.
    public List<Todo> findAll() {
        return store;
    }
    //id로 찾기(모든 리스트를 가져옴)
    public List<Todo> findByUserId(int userId) {
        List<Todo> result = new ArrayList<>();
        for (Todo t : store) {
            if (t.getUserId() == userId) { //userId가 같으면 result에 추가
                result.add(t);
            }
        }
        return result; //result 리스트 반환
    }
    //완료
    public Todo completeTodo(int userId, String todo) {
        for (Todo t : store) {
            //userId와 todo가 모두 동일하다면
            if (t.getUserId() == userId && t.getTodo().equals(todo)) {
                t.setCompleted(); //상태 변경 메서드 호출
                return t;

            }
        }return null; //못찾았다면 null 반환
    }
    //complete 상태로 찾기
    public List<Todo> returnCompleted(boolean tf) {
        List<Todo> result = new ArrayList<>();
        for (Todo t : store) {
            if (t.isCompleted() == tf) {
                result.add(t);
            }
        }
        return result;
    }




}
