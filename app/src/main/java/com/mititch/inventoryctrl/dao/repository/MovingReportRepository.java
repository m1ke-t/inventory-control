package com.mititch.inventoryctrl.dao.repository;

import com.mititch.inventoryctrl.model.MovingReport;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MovingReportRepository extends PagingAndSortingRepository<MovingReport, Long>, JpaSpecificationExecutor {
}
