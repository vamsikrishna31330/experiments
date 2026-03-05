package com.example.ProductApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService ps;
	@PostMapping("/insert")
	public void insert(Product p) {
		ps.insert(p);
	}
	
}
