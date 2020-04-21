package com.productapi.productapi.repository;

import com.productapi.productapi.model.Products;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

}