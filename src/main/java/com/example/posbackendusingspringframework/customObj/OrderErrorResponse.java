package com.example.posbackendusingspringframework.customObj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderErrorResponse implements Serializable,OrderResponse {
    private int errorCode;
    private String errorMessage;
}
