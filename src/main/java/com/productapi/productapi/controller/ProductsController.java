package com.productapi.productapi.controller;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import com.productapi.productapi.model.Products;
import com.productapi.productapi.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PostMapping(value = "/products/createproducts")
    public ResponseEntity <Object> createProducts (@RequestBody List <Products> products) {
        List<Products> savedProducts = productsRepository.saveAll(products);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{product_id}")
                        .buildAndExpand(savedProducts.toArray()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/products/updateproduct/{product_id}")
    public ResponseEntity <Object> updateProduct (@Valid @RequestBody Products products, @PathVariable int product_id ) {
        Optional<Products> productsOptional = productsRepository.findById(product_id);
        if(!productsOptional.isPresent()) 
            return ResponseEntity.notFound().build();
        products.setProduct_id(product_id);
        productsRepository.save(products);
        return ResponseEntity.noContent().build();
    } 

    @DeleteMapping(value = "/products/deleteproduct/{product_id}")
    public void deleteProducts(@PathVariable int product_id) {
        productsRepository.deleteById(product_id);        
    }
}