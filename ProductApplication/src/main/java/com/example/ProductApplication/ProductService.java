package com.example.ProductApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired 
    ProductRepository pr;

    public void insert(Product p) {
    	pr.save(p);
    	
    }


}
