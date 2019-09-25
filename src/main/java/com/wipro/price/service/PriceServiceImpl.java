package com.wipro.price.service;

import com.wipro.price.model.ProductPrice;
import com.wipro.price.repo.PriceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
    public ProductPrice getPriceByProductId(Long productId) {

        ProductPrice productPrice = new ProductPrice();

        productPrice.setPriceId(priceRepo.findById(productId).get().getPriceId());
        productPrice.setPrice(priceRepo.findById(productId).get().getPrice());
        productPrice.setProductId(priceRepo.findById(productId).get().getProductId());
        productPrice.setCurrency(priceRepo.findById(productId).get().getCurrency());
        return productPrice;
    }

    @Override
    public ProductPrice saveOrUpdatePrice(ProductPrice productPrice) {
         return priceRepo.save(productPrice);
    }

    @Override
    public void deletePricebyProductId(Long productId) {
         priceRepo.deleteById(productId);
    }
}
