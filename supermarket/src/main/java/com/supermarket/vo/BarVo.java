package com.supermarket.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 柱状图，根据烧烤商品名跟剩余数量
 */
public class BarVo {

    private String barbecue_name;
    private Integer barbecue_num;
}
