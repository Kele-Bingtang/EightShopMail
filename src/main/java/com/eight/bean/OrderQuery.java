package com.eight.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderQuery {
    private Integer pageNum=1;
    private Integer pageSize=5;
    private String returnType;
}
