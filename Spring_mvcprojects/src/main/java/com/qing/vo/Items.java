package com.qing.vo;

import java.util.Date;

/**
 * 商品列表
 */
public class Items {
    private int itemId;
    private String itemsName;
    private String itemsPrice;
    private Date itemsCreatetime;

    public Items() {
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemsName() {
        return itemsName;
    }

    public void setItemsName(String itemsName) {
        this.itemsName = itemsName;
    }

    public String getItemsPrice() {
        return itemsPrice;
    }

    public void setItemsPrice(String itemsPrice) {
        this.itemsPrice = itemsPrice;
    }

    public Date getItemsCreatetime() {
        return itemsCreatetime;
    }

    public void setItemsCreatetime(Date itemsCreatetime) {
        this.itemsCreatetime = itemsCreatetime;
    }

    @Override
    public String toString() {
        return "Items{" +
                "itemId=" + itemId +
                ", itemsName='" + itemsName + '\'' +
                ", itemsPrice='" + itemsPrice + '\'' +
                ", itemsCreatetime=" + itemsCreatetime +
                '}';
    }
}
