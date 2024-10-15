package com.example.posbackendusingspringframework.service;

import com.example.posbackendusingspringframework.customObj.CustomerResponse;
import com.example.posbackendusingspringframework.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> getAllCustomers();

    CustomerResponse getSelectedCustomer(String id);

    void updateCustomer(String id, CustomerDTO customerDTO);

    void deleteCustomer(String id);
}
