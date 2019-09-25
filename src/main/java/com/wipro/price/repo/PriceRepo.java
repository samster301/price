package com.wipro.price.repo;

import com.wipro.price.model.ProductPrice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PriceRepo extends CrudRepository<ProductPrice,Long>{
}
