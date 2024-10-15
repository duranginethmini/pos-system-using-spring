package com.example.posbackendusingspringframework.dto;

import com.example.posbackendusingspringframework.customObj.OrderDetailResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailDTO implements SuperDTO, OrderDetailResponse {
    private String itemCode;
    private String itemName;
    private String itemDescription;
    private int qty;
    private double unitPrice;
    private double total;
}
