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
@Table(name = "items")
public class ItemEntity implements SuperEntity{
    @Id
    private String itemCode;
    private String itemName;
    private int qty;
    private int unitPrice;
}
