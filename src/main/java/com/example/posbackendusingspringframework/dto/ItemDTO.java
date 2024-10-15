package com.example.posbackendusingspringframework.dto;

import com.example.posbackendusingspringframework.customObj.ItemResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO implements SuperDTO, ItemResponse {
    private String itemCode;
    private String itemName;
    private int qty;
    private int unitPrice;
}
