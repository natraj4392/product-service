package com.productapi.productapi.controller;
import java.net.URI;
import java.util.List;
import com.productapi.productapi.model.Products;
import com.productapi.productapi.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController

public class ProductsController {

    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping(value = "/products/getproducts")
    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    @PostMapping(value = "/products/postproducts")
    public ResponseEntity<Object> createProducts (@RequestBody List<Products> products) {
        List<Products> savedProducts = productsRepository.saveAll(products);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{product_id}")
                        .buildAndExpand(savedProducts.toArray()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/products/{product_id}")
    public void deleteProducts(@PathVariable int product_id) {
        productsRepository.deleteById(product_id);        
    }
}