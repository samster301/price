package com.wipro.price.controller;

import com.wipro.price.Exception.PriceNotFoundException;
import com.wipro.price.model.ProductPrice;
import com.wipro.price.service.PriceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

@EnableDiscoveryClient
@EnableEurekaClient
@RestController
@RequestMapping("/products")
public class PriceController {

    @Autowired
    PriceService priceService;

    @GetMapping(value= "/prices/swagger-ui")
    public ModelAndView redirectToSwagger(){
        return new ModelAndView("redirect:/swagger-ui.html");
    }

    @ApiOperation(value = "find all prices", response = List.class)
    @GetMapping("/listAll")
    public List<ProductPrice> displayAllPrice() {
        return priceService.getAllPrice();
    }

    @ApiOperation(value = "find price for a product ID", response = BigDecimal.class)
    @GetMapping("{productId}/listPrice")
    public BigDecimal displayPriceByProduct(@PathVariable int productId) throws PriceNotFoundException {
        return priceService.getPriceByProductId(productId);
    }
    @ApiOperation(value = "Add a new price", response = ResponseEntity.class)
    @PostMapping("/addPrice")
    public ResponseEntity<Object> addPrice(@RequestBody ProductPrice productPrice) {
        ProductPrice savedPrice = priceService.saveOrUpdatePrice(productPrice);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{productId}").buildAndExpand(savedPrice.getProductId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @ApiOperation(value = "Delete a price", response = ResponseEntity.class)
    @RequestMapping(value = "/deleteById/{productId}")
    public ResponseEntity deletePrice(@PathVariable int productId) {
        priceService.deletePricebyProductId(productId);
        return new ResponseEntity(HttpStatus.OK);
    }

}
