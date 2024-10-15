package com.example.posbackendusingspringframework.service;

import com.example.posbackendusingspringframework.dto.OrderDTO;
import com.example.posbackendusingspringframework.dto.OrderDetailDTO;

import java.util.List;

public interface OrderService {
    void saveOrder(OrderDTO orderDTO);

    List<OrderDetailDTO> getOrderDetail();

}
