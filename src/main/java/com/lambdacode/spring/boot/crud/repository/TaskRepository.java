package com.lambdacode.spring.boot.crud.repository;

import com.lambdacode.spring.boot.crud.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
