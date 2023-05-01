package com.example.supermarket.repository;

import java.beans.JavaBean;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.supermarket.model.*;
@JavaBean
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findByEmail(String email);
}
