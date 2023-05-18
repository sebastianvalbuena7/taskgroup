package com.sebastian.taskgroup.infrastructure.services;

import com.sebastian.taskgroup.api.models.request.CustomerRequest;
import com.sebastian.taskgroup.api.models.response.CustomerResponse;
import com.sebastian.taskgroup.domain.entities.CustomerEntity;
import com.sebastian.taskgroup.domain.repositories.CustomerRepository;
import com.sebastian.taskgroup.infrastructure.abstract_services.ICustomerService;
import com.sebastian.taskgroup.infrastructure.helper.EmailHelper;
import com.sebastian.taskgroup.util.enums.Tables;
import com.sebastian.taskgroup.util.exceptions.IdNotFoundException;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class CustomerService implements ICustomerService {
    private final CustomerRepository customerRepository;
    private final EmailHelper emailHelper;

    @Override
    public CustomerResponse create(CustomerRequest request) {
        var customerPersist = CustomerEntity.builder()
                .name(request.getName())
                .email(request.getEmail())
                .build();
        var customerPersistent = customerRepository.save(customerPersist);
        if(Objects.nonNull(request.getEmail())) emailHelper.sendMail(request.getEmail(), request.getName());
        return entityToResponse(customerPersistent);
    }

    @Override
    public CustomerResponse read(Long aLong) {
        var customerFind = customerRepository.findById(aLong).orElseThrow(() -> new IdNotFoundException(Tables.customer.name()));
        return entityToResponse(customerFind);
    }

    @Override
    public CustomerResponse update(CustomerRequest request, Long aLong) {
        var customerFind = customerRepository.findById(aLong).orElseThrow(() -> new IdNotFoundException(Tables.customer.name()));
        customerFind.setName(request.getName());
        customerFind.setEmail(request.getEmail());
        var customerPersist = customerRepository.save(customerFind);
        return entityToResponse(customerPersist);
    }

    @Override
    public void delete(Long aLong) {
        var customerFind = customerRepository.findById(aLong).orElseThrow(() -> new IdNotFoundException(Tables.customer.name()));
        customerRepository.deleteById(customerFind.getId());
    }

    private CustomerResponse entityToResponse(CustomerEntity customer) {
        CustomerResponse customerResponse = new CustomerResponse();
        BeanUtils.copyProperties(customer, customerResponse);
        return customerResponse;
    }
}