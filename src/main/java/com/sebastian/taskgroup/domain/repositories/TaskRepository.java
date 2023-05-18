package com.sebastian.taskgroup.domain.repositories;

import com.sebastian.taskgroup.domain.entities.TaskEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TaskRepository extends CrudRepository<TaskEntity, UUID> {
}