package com.mititch.inventoryctrl.controllers;

import com.mititch.inventoryctrl.model.Product;
import com.mititch.inventoryctrl.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Mike S. on 27.06.2019.
 */
@RestController
@Slf4j
public class ProductController {
    @Autowired
    private ProductService rs;

    @GetMapping(value = "getAll/product")
    public List<Product> getAll() {
        List<Product> r = rs.getAll();
        for (Product product : r) {
            log.debug(product.toString());
        }
        return rs.getAll();
    }

    @GetMapping(value = "/add/product/{name}")
    public Product add(@PathVariable("name") String name) {
        Product r = rs.addProduct(new Product(name));
        log.debug(r.toString());
        return r;
    }

    @GetMapping(value = "/delete/product/{id}")
    public void delete(@PathVariable("id") long id) {
        rs.delete(rs.getById(id).get());
    }

    @GetMapping(value = "/get/product/{id}")
    public Product getById(@PathVariable("id") long id) {
        return rs.getById(id).get();
    }
}
