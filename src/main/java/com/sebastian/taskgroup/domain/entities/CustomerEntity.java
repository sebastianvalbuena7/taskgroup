package com.sebastian.taskgroup.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String email;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<ProjectEntity> projects;

    @PrePersist
    @PreRemove
    public void updateFks() {
        if (Objects.isNull(this.projects)) this.projects = new HashSet<>();
        this.projects.forEach(projectEntity -> projectEntity.setCustomer(this));
    }

    public void removeProject(UUID idProject) {
        if (Objects.isNull(this.projects)) this.projects = new HashSet<>();
        this.projects.forEach(projectEntity -> {
            if (projectEntity.getId().equals(idProject)) {
                projectEntity.setCustomer(null);
            }
        });
    }

    public void addProject(ProjectEntity project) {
        if (Objects.isNull(this.projects)) this.projects = new HashSet<>();
        this.projects.add(project);
        this.projects.forEach(project1 -> project1.setCustomer(this));
    }
}