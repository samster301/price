package com.wipro.price.service;

import com.wipro.price.model.ProductPrice;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface PriceService {

    public List<ProductPrice> getAllPrice();

    public BigDecimal getPriceByProductId(int productId);

    public ProductPrice saveOrUpdatePrice(ProductPrice productPrice);

    public void deletePricebyProductId(int productId);
}
