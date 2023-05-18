package com.sebastian.taskgroup.domain.repositories;

import com.sebastian.taskgroup.domain.entities.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
}