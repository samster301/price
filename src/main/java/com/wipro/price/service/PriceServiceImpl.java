package com.wipro.price.service;

import com.wipro.price.model.ProductPrice;
import com.wipro.price.repo.PriceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PriceServiceImpl implements PriceService {

    @Autowired
    PriceRepo priceRepo;

    @Override
    public List<ProductPrice> getAllPrice() {
        return (List<ProductPrice>) priceRepo.findAll();
    }

    @Override
    public BigDecimal getPriceByProductId(int productId) {
        return priceRepo.findById(productId).get().getPrice();
    }

    @Override
    public ProductPrice saveOrUpdatePrice(ProductPrice productPrice) {
         return priceRepo.save(productPrice);
    }

    @Override
    public void deletePricebyProductId(int productId) {
         priceRepo.deleteById(productId);
    }
}
