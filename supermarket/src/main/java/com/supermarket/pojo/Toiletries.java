package com.supermarket.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Toiletries {
    @JsonProperty("id")
    private Integer tid;
    @JsonProperty("name")
    private String tname;
    @JsonProperty("brand")
    private String tbrand;
    @JsonProperty("price")
    private double tprice;
    @JsonProperty("stock")
    private Integer tstock;
    @JsonProperty("pic")
    private String tpic;
}
