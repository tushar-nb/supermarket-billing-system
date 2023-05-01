package com.example.supermarket.model;

import java.util.List;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NonNull
    private String name;

    @NonNull
    private float price;

    @NonNull
    private int total;

    @NonNull
    private int available;

    public Products orElse(Object object) {
        return null;
    }

    public void setAdmin(Admin admin) {
    }

    public void setSeller(Seller seller) {
    }

    public Products saveProduct(Products product) {
        return null;
    }

    public List<Products> getProductsBySeller(Seller seller) {
        return null;
    }

    public void deleteProductByIdAndSeller(int productId, Seller seller) {
    }

	public Products(int int1, String string, double double1, int int2, int int3) {
	}

    public Object getTotalQuantity() {
        return null;
    }

    public Object getAvailableQuantity() {
        return null;
    }
    
}
