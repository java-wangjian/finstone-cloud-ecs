/*
 * =============================================================
 * Copyright (c) 2012 ~ 2019. finstone.com All rights reserved.
 *                                           Created by wangjian
 * =============================================================
 */
package com.finstone.order.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Author: wangjian
 * Date:   19-10-17
 * Description:
 */
@TableName(value = "orders", schema = "orders_database", resultMap = "ordersMap")
public class Orders {

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    @TableField(value = "order_no")
    private String orderNO;

    @TableField(value = "order_status")
    private String orderStatus="0";

    @TableField(value = "finish_date", fill = FieldFill.UPDATE)
    private Date finishDate;

    @TableField(value = "delete_date", fill = FieldFill.UPDATE)
    private Date deleteDate;

    @TableField(value = "create_date", fill = FieldFill.INSERT)
    private Date createDate;

    @TableField(value = "create_user")
    private String createUser="wangjian";

    @TableField(value = "update_date", fill = FieldFill.INSERT_UPDATE)
    private Date updateDate;

    @TableField(value = "update_user")
    private String updateUser="wangjian";

    @TableField(value = "amount")
    private double amount;

    @TableField(exist = false)
    private List<OrderDetail> orderDetailList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNO() {
        return orderNO;
    }

    public void setOrderNO(String orderNO) {
        this.orderNO = orderNO;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders that = (Orders) o;
        return Double.compare(that.amount, amount) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(orderNO, that.orderNO) &&
                Objects.equals(orderStatus, that.orderStatus) &&
                Objects.equals(finishDate, that.finishDate) &&
                Objects.equals(deleteDate, that.deleteDate) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(createUser, that.createUser) &&
                Objects.equals(updateDate, that.updateDate) &&
                Objects.equals(updateUser, that.updateUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderNO, orderStatus, finishDate, deleteDate, createDate, createUser, updateDate, updateUser, amount);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", orderNO='" + orderNO + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", finishDate=" + finishDate +
                ", deleteDate=" + deleteDate +
                ", createDate=" + createDate +
                ", createUser='" + createUser + '\'' +
                ", updateDate=" + updateDate +
                ", updateUser='" + updateUser + '\'' +
                ", amount=" + amount +
                '}';
    }
}
