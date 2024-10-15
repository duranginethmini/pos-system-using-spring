package com.example.posbackendusingspringframework.dto;

import com.example.posbackendusingspringframework.customObj.OrderResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements SuperDTO, OrderResponse {
    private String oId;
    private String date;
    private double total;
    private String custId;
    private List<OrderDetailDTO> orderDetails;
}
