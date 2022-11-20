package com.supermarket.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.regex.Pattern;

public class SExpanded {
    /**
     * id
     */
    private Integer id;
    /**
     *
     */
    private String pic;

    private String name;

    private String number;

    private BigDecimal price;

    private String weight;

    private String discount;

    private String quantity;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")// json形式
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date launchdate;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")// json形式
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dm;

    private String qgperiod;

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