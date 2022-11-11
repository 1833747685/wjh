package com.supermarket.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Svip {

    private Integer vid;
    private String vname;
    private Integer vage;
    private String vsex;
    private String vaddress;
    @JsonFormat(pattern = "yyyy-MM-dd",locale = "zh",timezone = "GMT+8")
//  @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date vcreatTime;
    private String vimg;
}

