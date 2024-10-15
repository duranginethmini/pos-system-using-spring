package com.example.posbackendusingspringframework.util;

import com.example.posbackendusingspringframework.dto.CustomerDTO;
import com.example.posbackendusingspringframework.dto.ItemDTO;
import com.example.posbackendusingspringframework.dto.OrderDTO;
import com.example.posbackendusingspringframework.dto.OrderDetailDTO;
import com.example.posbackendusingspringframework.entity.CustomerEntity;
import com.example.posbackendusingspringframework.entity.ItemEntity;
import com.example.posbackendusingspringframework.entity.OrderDetailEntity;
import com.example.posbackendusingspringframework.entity.OrderEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    public ModelMapper modelMapper;

    //Customer
    public CustomerDTO convertCustomerEntityToCustomerDTO(CustomerEntity customerEntity) {
        return modelMapper.map(customerEntity, CustomerDTO.class);
    }

    public CustomerEntity convertCustomerDTOToCustomerEntity(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, CustomerEntity.class);
    }

    public List<CustomerDTO> convertCustomerEntityListToCustomerDTOList(List<CustomerEntity> customerEntityList) {
        return modelMapper.map(customerEntityList, new TypeToken<List<CustomerDTO>>() {}.getType());
    }

    //Items
    public ItemDTO convertItemEntityToItemDTO(ItemEntity itemEntity) {
        return modelMapper.map(itemEntity, ItemDTO.class);
    }

    public ItemEntity convertItemDTOToItemEntity(ItemDTO itemDTO) {
        return modelMapper.map(itemDTO, ItemEntity.class);
    }

    public List<ItemDTO> convertItemEntityListToItemDTOList(List<ItemEntity> itemEntityList) {
        return modelMapper.map(itemEntityList, new TypeToken<List<ItemDTO>>() {}.getType());
    }

    //orders
    public OrderDTO convertOrderEntityToOrderDTO(OrderEntity orderEntity) {
        return modelMapper.map(orderEntity, OrderDTO.class);
    }

    public OrderEntity convertOrderDTOToOrderEntity(OrderDTO orderDTO) {
        return modelMapper.map(orderDTO, OrderEntity.class);
    }

    //orderDetail
    public OrderDetailDTO convertOrderDetailsEntityToOrderDetailsDTO(OrderDetailEntity orderDetailsEntity) {
        return modelMapper.map(orderDetailsEntity, OrderDetailDTO.class);
    }

    public OrderDetailEntity convertOrderDetailsDTOToOrderDetailsEntity(OrderDetailDTO orderDetailsDTO) {
        return modelMapper.map(orderDetailsDTO, OrderDetailEntity.class);
    }

    public List<OrderDetailDTO> convertOrderDetailEntityListToOrderDetailDTOList(List<OrderDetailEntity> orderDetailsEntityList) {
        return modelMapper.map(orderDetailsEntityList, new TypeToken<List<OrderDetailDTO>>() {}.getType());
    }
}
