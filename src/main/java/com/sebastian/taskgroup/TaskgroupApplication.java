package com.sebastian.taskgroup;

import com.sebastian.taskgroup.domain.entities.CustomerEntity;
import com.sebastian.taskgroup.domain.entities.ProjectEntity;
import com.sebastian.taskgroup.domain.entities.TaskEntity;
import com.sebastian.taskgroup.domain.repositories.CustomerRepository;
import com.sebastian.taskgroup.domain.repositories.ProjectRepository;
import com.sebastian.taskgroup.domain.repositories.TaskRepository;
import com.sebastian.taskgroup.util.enums.TypeProject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@SpringBootApplication
@Slf4j
public class TaskgroupApplication implements CommandLineRunner {
	private final CustomerRepository customerRepository;
	private final ProjectRepository projectRepository;
	private final TaskRepository taskRepository;

	public TaskgroupApplication(CustomerRepository customerRepository, ProjectRepository projectRepository, TaskRepository taskRepository) {
		this.customerRepository = customerRepository;
		this.projectRepository = projectRepository;
		this.taskRepository = taskRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(TaskgroupApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		var project = TaskEntity.builder()
//				.id(UUID.randomUUID())
//				.date_end(LocalDateTime.now())
//				.name("Works")
//				.description("Dont works")
//				.project(project2)
//				.build();
//		taskRepository.save(project);

//		var customer = CustomerEntity.builder()
//				.email("sebastian@correo.com")
//				.name("Sebastian Valbuena")
//				.build();
//		customerRepository.save(customer);
//
//		var customer2 = CustomerEntity.builder()
//				.email("fiore@correo.com")
//				.name("Fiorella Cejade")
//				.build();
//		customerRepository.save(customer2);
//
//		var project2 = ProjectEntity.builder()
//				.id(UUID.randomUUID())
//				.customer(customer)
//				.name("Project X")
//				.budget(BigDecimal.valueOf(3400))
//				.date_end(LocalDate.now().plusMonths(2))
//				.type(TypeProject.Technology)
//				.date_start(LocalDate.now())
//				.build();
//		projectRepository.save(project2);
	}
}