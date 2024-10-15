package com.example.posbackendusingspringframework.dto;

import com.example.posbackendusingspringframework.customObj.CustomerResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements SuperDTO, CustomerResponse {
    private String custId;
    private String custName;
    private String custAddress;
    private String custSalary;
}
