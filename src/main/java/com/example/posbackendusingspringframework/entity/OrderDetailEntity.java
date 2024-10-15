package com.example.posbackendusingspringframework.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orderDetail")
public class OrderDetailEntity {
    @Id
    private String itemCode;
    private String itemName;
    private String itemDescription;
    private int qty;
    private double unitPrice;
    private double total;

}
