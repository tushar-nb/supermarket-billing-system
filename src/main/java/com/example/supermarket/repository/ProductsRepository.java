package com.example.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.supermarket.model.*;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

    Products findByName(String name);

}
