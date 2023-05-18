package com.sebastian.taskgroup.domain.entities;

import com.sebastian.taskgroup.util.enums.TypeProject;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity(name = "project")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProjectEntity {
    @Id
    private UUID id;
    private String name;
    private LocalDate date_start;
    private LocalDate date_end;
    private TypeProject type;
    private BigDecimal budget;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<TaskEntity> tasks;
}