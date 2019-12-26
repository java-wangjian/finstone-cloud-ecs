/*
 * =============================================================
 * Copyright (c) 2012 ~ 2019. wangshi.com All rights reserved.
 *                                           Created by wangjian
 * =============================================================
 */
package com.wangshi.order.entity;

import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;
import java.util.Objects;

/**
 * Author: wangjian
 * Date:   19-10-17
 * Description:
 */

@TableName(value = "orders_detail", schema = "orders_database")
public class OrderDetail {

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    @TableField(value = "orders_id")
    private String orderId;

    @TableField(value = "commodity_id")
    private String commodityId;

    @TableField(value = "commodity_name")
    private String commodityName;

    @TableField(value = "price")
    private double price;

    @TableField(value = "quantity")
    private int quantity;

    @TableField(value = "amount")
    private Double amount;

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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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
        OrderDetail that = (OrderDetail) o;
        return Double.compare(that.price, price) == 0 &&
                quantity == that.quantity &&
                Objects.equals(id, that.id) &&
                Objects.equals(orderId, that.orderId) &&
                Objects.equals(commodityId, that.commodityId) &&
                Objects.equals(commodityName, that.commodityName) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(createUser, that.createUser) &&
                Objects.equals(updateDate, that.updateDate) &&
                Objects.equals(updateUser, that.updateUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, commodityId, commodityName, price, quantity, amount, createDate, createUser, updateDate, updateUser);
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id='" + id + '\'' +
                ", orderId='" + orderId + '\'' +
                ", commodityId='" + commodityId + '\'' +
                ", commodityName='" + commodityName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", amount=" + amount +
                ", createDate=" + createDate +
                ", createUser='" + createUser + '\'' +
                ", updateDate=" + updateDate +
                ", updateUser='" + updateUser + '\'' +
                '}';
    }
}
