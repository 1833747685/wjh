package com.supermarket.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Electrical {
    @JsonProperty("id")
    private Integer elid;
    @JsonProperty("name")
    private String elname;
    @JsonProperty("brand")
    private String elbrand;
    @JsonProperty("price")
    private double elprice;
    @JsonProperty("stock")
    private Integer elstock;
    @JsonProperty("pic")
    private String elpic;
}
