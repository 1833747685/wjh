package com.supermarket.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @date 2022/10/10
 * @desc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LayuiPageVo<T> {

    private Integer code;   // layui 默认 成功的 code 是 0

    private String msg;

    private Long count;

    private List<T> data;
}
