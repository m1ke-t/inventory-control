package com.mititch.inventoryctrl.dao.repository;

import com.mititch.inventoryctrl.model.Statement;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Mike S. on 27.06.2019.
 */
public interface StatementRepository extends PagingAndSortingRepository<Statement, Long>, JpaSpecificationExecutor {
}
