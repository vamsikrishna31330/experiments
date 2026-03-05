package com.example.ProductApplication;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Integer>{
 List <Product> findByCategory(String category);	
 List <Product> findByPriceBetween(double min,double max);
 
 //Sorting products by price
 @Query("Select p from Product p order by p.price ASC")
 //Fetching products by category
 //select * from product where price>given value
 List<Product> getProductPrice();
 @Query("Select p from Product p where p.price>:price")
 List<Product> getProductAbovePrice(@Param("price")float price);
 @Query("select * from product p where p.category=:category")
 List<Product> getProductByCategory(String Category);
}
