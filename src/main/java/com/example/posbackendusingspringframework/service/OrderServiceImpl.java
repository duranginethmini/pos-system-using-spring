package com.example.posbackendusingspringframework.service;

import com.example.posbackendusingspringframework.dao.OrderDAO;
import com.example.posbackendusingspringframework.dao.OrderDetailDAO;
import com.example.posbackendusingspringframework.dto.OrderDTO;
import com.example.posbackendusingspringframework.dto.OrderDetailDTO;
import com.example.posbackendusingspringframework.entity.OrderDetailEntity;
import com.example.posbackendusingspringframework.entity.OrderEntity;
import com.example.posbackendusingspringframework.exception.DataPersistentException;
import com.example.posbackendusingspringframework.util.AppUtil;
import com.example.posbackendusingspringframework.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
    @Autowired
     private OrderDAO orderDAO;

    @Autowired
    private OrderDetailDAO orderDetailDAO;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveOrder(OrderDTO orderDTO) {
        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setOId(AppUtil.createOrderId());
        orderEntity.setDate(orderDTO.getDate());
        orderEntity.setTotal(orderDTO.getTotal());
        orderEntity.setCustId(orderDTO.getCustId());

        OrderEntity save = orderDAO.save(orderEntity);

        List<OrderDetailDTO> orderDetailsDTOS = orderDTO.getOrderDetails();

        for(OrderDetailDTO orderDetailsDTO : orderDetailsDTOS) {

            OrderDetailEntity orderDetailsEntity = new OrderDetailEntity();

            orderDetailsEntity.setItemCode(orderDetailsDTO.getItemCode());
            orderDetailsEntity.setItemName(orderDetailsDTO.getItemName());
            orderDetailsEntity.setItemDescription(orderDetailsDTO.getItemDescription());
            orderDetailsEntity.setQty(orderDetailsDTO.getQty());
            orderDetailsEntity.setUnitPrice(orderDetailsDTO.getUnitPrice());
            orderDetailsEntity.setTotal(orderDetailsDTO.getTotal());

            orderDetailDAO.save(orderDetailsEntity);
        }

        if(save == null){
            throw  new DataPersistentException("order save failed");
        }
    }

    @Override
    public List<OrderDetailDTO> getOrderDetail() {
       return mapping.convertOrderDetailEntityListToOrderDetailDTOList(orderDetailDAO.findAll());
    }
}
