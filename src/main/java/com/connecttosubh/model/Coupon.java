package com.connecttosubh.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Coupon {


    private Long id;
    private String code;
    private BigDecimal discount;
    private String exp_date;

}
