package com.supermarket.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class SMeatpro {
    //在Excel文件中给属性起别名
    @ExcelProperty("id")
    private Integer id;

    @ExcelProperty("图片")
    private String pic;

    @ExcelProperty("名字")
    private String name;

    @ExcelProperty("编号")
    private String number;

    @ExcelProperty("编号")
    private BigDecimal price;

    @ExcelProperty("重量")
    private String weight;

    @ExcelProperty("折扣")
    private String discount;

    @ExcelProperty("数量")
    private String quantity;

    @ExcelProperty("上架时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")// json形式
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date launchdate;

    @ExcelProperty("生产日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")// json形式
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dm;

    @ExcelProperty("保质期")
    private String qgperiod;

    @ExcelProperty("类型")
    private String lscategory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount == null ? null : discount.trim();
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity == null ? null : quantity.trim();
    }

    public Date getLaunchdate() {
        return launchdate;
    }

    public void setLaunchdate(Date launchdate) {
        this.launchdate = launchdate;
    }

    public Date getDm() {
        return dm;
    }

    public void setDm(Date dm) {
        this.dm = dm;
    }

    public String getQgperiod() {
        return qgperiod;
    }

    public void setQgperiod(String qgperiod) {
        this.qgperiod = qgperiod == null ? null : qgperiod.trim();
    }

    public String getLscategory() {
        return lscategory;
    }

    public void setLscategory(String lscategory) {
        this.lscategory = lscategory == null ? null : lscategory.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pic=").append(pic);
        sb.append(", name=").append(name);
        sb.append(", number=").append(number);
        sb.append(", price=").append(price);
        sb.append(", weight=").append(weight);
        sb.append(", discount=").append(discount);
        sb.append(", quantity=").append(quantity);
        sb.append(", launchdate=").append(launchdate);
        sb.append(", dm=").append(dm);
        sb.append(", qgperiod=").append(qgperiod);
        sb.append(", lscategory=").append(lscategory);
        sb.append("]");
        return sb.toString();
    }
}