package com.example.posbackendusingspringframework.service;

import com.example.posbackendusingspringframework.customObj.CustomerResponse;
import com.example.posbackendusingspringframework.dao.CustomerDAO;
import com.example.posbackendusingspringframework.dto.CustomerDTO;
import com.example.posbackendusingspringframework.entity.CustomerEntity;
import com.example.posbackendusingspringframework.exception.CustomerNotFoundException;
import com.example.posbackendusingspringframework.exception.DataPersistentException;
import com.example.posbackendusingspringframework.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private Mapping mapping;
    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        CustomerEntity save = customerDAO.save(mapping.convertCustomerDTOToCustomerEntity(customerDTO));
        if (save == null){
            throw new DataPersistentException("couldn't save customer");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return mapping.convertCustomerEntityListToCustomerDTOList(customerDAO.findAll());
    }

    @Override
    public CustomerResponse getSelectedCustomer(String id) {
        if (customerDAO.existsById(id)) {
            return mapping.convertCustomerEntityToCustomerDTO(customerDAO.getReferenceById(id));
        }else {
            throw new CustomerNotFoundException("Customer not found");
        }
    }

    @Override
    public void updateCustomer(String id, CustomerDTO customerDTO) {
        Optional<CustomerEntity> tmp = customerDAO.findById(id);
        if (!tmp.isPresent()) {
            throw new CustomerNotFoundException("Customer not found");
        }else {
            tmp.get().setCustName(customerDTO.getCustName());
            tmp.get().setCustAddress(customerDTO.getCustAddress());
            tmp.get().setCustSalary(customerDTO.getCustSalary());
        }
    }

    @Override
    public void deleteCustomer(String id) {
        Optional<CustomerEntity> tmp = customerDAO.findById(id);
        if (!tmp.isPresent()) {
            throw new CustomerNotFoundException("Customer not found");
        }else {
            customerDAO.deleteById(id);
        }
    }
}
