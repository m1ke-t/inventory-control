package com.mititch.inventoryctrl.dao.repository;


import com.mititch.inventoryctrl.model.Product;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long>, JpaSpecificationExecutor {
}
