package com.desafio.agibank.importalotes.domain.entity;

import java.math.BigDecimal;

public class Item {

    private Integer itemId;
    private Integer itemQuantity;
    private BigDecimal itemPrice;

    public static class Builder {

        private Integer itemId;
        private Integer itemQuantity;
        private BigDecimal itemPrice;

        public Builder itemId(Integer itemId) {
            this.itemId = itemId;
            return this;
        }

        public Builder itemQuantity(Integer itemQuantity) {
            this.itemQuantity = itemQuantity;
            return this;
        }

        public Builder itemPrice(BigDecimal itemPrice) {
            this.itemPrice = itemPrice;
            return this;
        }

        public Item build() {
            return new Item(this);
        }
    }

    private Item(Builder builder) {
        this.itemId = builder.itemId;
        this.itemQuantity = builder.itemQuantity;
        this.itemPrice = builder.itemPrice;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }
}
