package com.etiya.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.northwind.entities.concretes.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findById(int id);

    List<Product> findByCategoryCategoryId(int id);

    Product findByProductName(String name);   //veritabanından gelecek ürün için karşılaştırma yapmak için kullanıcaz



}
