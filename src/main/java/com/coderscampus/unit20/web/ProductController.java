package com.coderscampus.unit20.web;

import com.coderscampus.unit20.domain.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private List<Product> allProducts = new ArrayList<>();

    public ProductController () {
        allProducts.add((new Product(1, "shoes", new BigDecimal("50.00"))));
        allProducts.add((new Product(2, "gucci", new BigDecimal("100.00"))));
        allProducts.add((new Product(3, "shirt", new BigDecimal("25.00"))));
        allProducts.add((new Product(4, "shorts", new BigDecimal("40.00"))));
        allProducts.add((new Product(5, "pants", new BigDecimal("70.00"))));

    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllproducts() {
        return ResponseEntity.ok(allProducts);
    }
}
