package com.finstone.commodity.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Author: wangjian
 * Date:   19-10-15
 * Description:
 */
@TableName(value = "commodity", schema = "commodity_database")
public class Commodity implements Serializable {

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    @TableField(value = "commodity_name")
    private String commodityName;

    @TableField(value = "commodity_stock")
    private Integer commodityStock;

    @TableField(value = "commodity_price")
    private double commodityPrice;

    @TableField(value = "create_date", fill = FieldFill.INSERT)
    private Date createDate;

    @TableField(value = "create_user")
    private String createUser = "wangjian";

    @TableField(value = "update_date", fill = FieldFill.INSERT_UPDATE)
    private Date updateDate;

    @TableField(value = "update_user")
    private String updateUser = "wangjian";


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public Integer getCommodityStock() {
        return commodityStock;
    }

    public void setCommodityStock(Integer commodityStock) {
        this.commodityStock = commodityStock;
    }

    public double getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(double commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commodity that = (Commodity) o;
        return commodityPrice == that.commodityPrice &&
                Objects.equals(id, that.id) &&
                Objects.equals(commodityName, that.commodityName) &&
                Objects.equals(commodityStock, that.commodityStock) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(createUser, that.createUser) &&
                Objects.equals(updateDate, that.updateDate) &&
                Objects.equals(updateUser, that.updateUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, commodityName, commodityStock, commodityPrice, createDate, createUser, updateDate, updateUser);
    }
}
