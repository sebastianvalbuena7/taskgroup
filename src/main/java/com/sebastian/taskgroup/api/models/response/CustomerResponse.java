package com.sebastian.taskgroup.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class CustomerResponse {
    private Long id;
    private String name;
    private String email;
}