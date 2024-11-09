package com.capricon.TaskManagement_BackEnd.repo;

import com.capricon.TaskManagement_BackEnd.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepo extends JpaRepository<Task, Integer> {

    //We extend all methods from JpaRepo to perform CRUD operations

}
