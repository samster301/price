package com.wipro.price.service;

import com.wipro.price.model.ProductPrice;

import java.util.List;

public interface PriceService {

    public List<ProductPrice> getAllPrice();

    public ProductPrice getPriceByProductId(Long productId);

    public ProductPrice saveOrUpdatePrice(ProductPrice productPrice);

    public void deletePricebyProductId(Long productId);
}
