package com.sebastian.taskgroup.api.controllers;

import com.sebastian.taskgroup.api.models.request.CustomerRequest;
import com.sebastian.taskgroup.api.models.response.CustomerResponse;
import com.sebastian.taskgroup.infrastructure.abstract_services.ICustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {
    private final ICustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponse> post(@Valid @RequestBody CustomerRequest customerRequest) {
        return ResponseEntity.ok(customerService.create(customerRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.read(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> put(@PathVariable Long id, @Valid @RequestBody CustomerRequest customerRequest) {
        return ResponseEntity.ok(customerService.update(customerRequest, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}