package com.supermarket.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Smokes {
    private Integer sid;
    private String sbrand;
    private String sname;
    private String sprice;
    private String stype;
    private String stotal;
    private  String spic;
}
