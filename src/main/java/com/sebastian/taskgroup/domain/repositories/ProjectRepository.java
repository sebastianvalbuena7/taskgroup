package com.sebastian.taskgroup.domain.repositories;

import com.sebastian.taskgroup.domain.entities.ProjectEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProjectRepository extends CrudRepository<ProjectEntity, UUID> {
}
