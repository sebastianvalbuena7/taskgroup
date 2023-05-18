package com.sebastian.taskgroup.api.models.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class CustomerRequest {
    @NotBlank(message = "The name is required")
    private String name;
    @NotBlank(message = "The email is required")
    @Email(message = "You should put a valid email")
    private String email;
}