package com.mititch.inventoryctrl.services;

import com.mititch.inventoryctrl.model.Product;

import java.util.List;
import java.util.Optional;

/**
 * Created by Mike S. on 27.06.2019.
 */
public interface ProductService {
    Product addProduct(Product receipt);

    void delete(Product product);

    Optional<Product> getById(long id);

    //    Receipt getByName(String name);
    List<Product> getAll();
}
