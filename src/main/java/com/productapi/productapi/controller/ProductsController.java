package com.productapi.productapi.controller;
import java.util.List;

// import javax.validation.Valid;

import com.productapi.productapi.model.Products;
import com.productapi.productapi.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductsController {

    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping(value = "/all")
    public List<Products> getAll() {
        return productsRepository.findAll();
    }

    @PostMapping(value = "/load")
    public List<Products> createProducts (@RequestBody List<Products> products) {   
        return productsRepository.saveAll(products);
               
    }

    @DeleteMapping(value = "/{product_id}")
    void deleteProducts(@PathVariable ("product_id") int product_id) {
        productsRepository.deleteById(product_id);        
    }
}