package com.sebastian.taskgroup.infrastructure.abstract_services;

import com.sebastian.taskgroup.api.models.request.CustomerRequest;
import com.sebastian.taskgroup.api.models.response.CustomerResponse;

public interface ICustomerService extends CrudService<CustomerRequest, CustomerResponse, Long>{

}