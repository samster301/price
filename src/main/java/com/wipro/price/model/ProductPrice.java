package com.wipro.price.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "productPrice")
public class ProductPrice {

    @Id
    @Column(name = "productId")
    private Long productId;

    @Column(name = "priceId")
    private int priceId;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "currency")
    private String currency;


    public ProductPrice(int priceId, Long productId, BigDecimal price, String currency) {
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
