package com.project.project.repository;

import com.project.project.model.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTaskRepo extends JpaRepository<SubTask, Long> {
}
