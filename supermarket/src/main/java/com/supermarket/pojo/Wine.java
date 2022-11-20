package com.supermarket.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wine {
    private Integer wid;
    private String wbrand;
    private String wname;
    private String wprice;
    private String wtype;
    private String wtotal;
    private  String wpic;
}
