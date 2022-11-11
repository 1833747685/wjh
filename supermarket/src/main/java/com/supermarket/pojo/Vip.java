package com.supermarket.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vip {
    private Integer sid;
    private String sname;
    private Integer sage;
    private String ssex;
    private String saddress;
    @JsonFormat(pattern = "yyyy-MM-dd",locale = "zh",timezone = "GMT+8")
//  @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date screatTime;
    private String simg;
}
