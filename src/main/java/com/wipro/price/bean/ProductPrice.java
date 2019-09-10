package com.wipro.price.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Currency;

@Entity
public class ProductPrice {

    @Id
    private int priceId;
    private int productId;
    private BigDecimal price;
    private Currency currency;


    public ProductPrice(int priceId, int productId, BigDecimal price, Currency currency) {
        this.priceId = priceId;
        this.productId = productId;
        this.price = price;
        this.currency = currency;
    }

    public ProductPrice() {
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
