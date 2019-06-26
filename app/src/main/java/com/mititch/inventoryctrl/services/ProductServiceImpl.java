package com.mititch.inventoryctrl.services;

import com.mititch.inventoryctrl.dao.repository.ProductRepository;
import com.mititch.inventoryctrl.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Mike S. on 27.06.2019.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product receipt) {
        return productRepository.save(receipt);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public Optional<Product> getById(long id) {
        return productRepository.findById(id);
    }

//    @Override
//    public Receipt getByName(String name) {
//        return null;
//    }

    @Override
    public List<Product> getAll() {
        return (List<Product>) productRepository.findAll();
    }
}
