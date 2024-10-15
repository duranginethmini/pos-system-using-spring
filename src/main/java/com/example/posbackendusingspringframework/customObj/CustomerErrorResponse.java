package com.example.posbackendusingspringframework.customObj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerErrorResponse implements Serializable,CustomerResponse {
    private int errorCode;
    private String errorMessage;
}
