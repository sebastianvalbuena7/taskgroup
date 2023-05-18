package com.sebastian.taskgroup.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "task")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TaskEntity {
    @Id
    private UUID id;
    private String name;
    private String description;
    private LocalDateTime date_end;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_project", nullable = true)
    private ProjectEntity project;
}