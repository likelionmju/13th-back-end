package com.example.ll_week08.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class TodoRepositoryImpl implements TodoRepository {

    private Map<Integer, Todo> map =new HashMap<>();

    @Override
    public Todo save(Todo todo) {
        return map.put(todo.getId(), todo);
    }

    @Override
    public Todo findById(int id){
        return map.get(id);
    }

    @Override
    public Todo done(int id, String result){
        map.get(id).setDone(result);
        return map.get(id);
    }

    @Override
    public List<Todo> findAll(){
        return new ArrayList<>(map.values());
    }
}
