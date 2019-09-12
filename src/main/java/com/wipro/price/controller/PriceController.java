package com.wipro.price.controller;

import com.wipro.price.Exception.PriceNotFoundException;
import com.wipro.price.model.ProductPrice;
import com.wipro.price.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/price")
public class PriceController {

    @Autowired
    PriceService priceService;

    @GetMapping("/listAll")
    public List<ProductPrice> displayAllPrice(){
        return priceService.getAllPrice();
    }

    @GetMapping("/listById/{productId}")
    public BigDecimal displayPriceByProduct(@PathVariable int productId) throws PriceNotFoundException {
        return priceService.getPriceByProductId(productId);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addPrice(@RequestBody ProductPrice productPrice){
        ProductPrice savedPrice = priceService.saveOrUpdatePrice(productPrice);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{productId}").buildAndExpand(savedPrice.getProductId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @RequestMapping(value = "/deleteById/{productId}")
    public ResponseEntity deletePrice(@PathVariable int productId){
        priceService.deletePricebyProductId(productId);
        return new ResponseEntity(HttpStatus.OK);
    }

}
