package com.example.ll_week09;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ll_week09.Todo;

@Repository
public interface TodoRepository extends JpaRepository <Todo, Long> {
}
