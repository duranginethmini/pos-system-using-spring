package com.example.posbackendusingspringframework.controller;

import com.example.posbackendusingspringframework.dto.OrderDTO;
import com.example.posbackendusingspringframework.dto.OrderDetailDTO;
import com.example.posbackendusingspringframework.exception.DataPersistentException;
import com.example.posbackendusingspringframework.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    @Autowired
    private final OrderService orderService;

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> placeOrder(@RequestBody OrderDTO orderDTO) {
        if (orderDTO == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            try {
                orderService.saveOrder(orderDTO);
                logger.info("Order placed successfully: {}", orderDTO);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }catch (DataPersistentException e){
                logger.error("Failed to persist order data: {}", orderDTO, e);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }catch (Exception e){
                logger.error("Unexpected error popped while saving order: {}", orderDTO, e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDetailDTO> getOrderDetails() {
        return orderService.getOrderDetail();
    }
}
