package com.mititch.inventoryctrl.services;

import com.mititch.inventoryctrl.model.MovingReport;

import java.util.List;
import java.util.Optional;

/**
 * Created by Mike S. on 27.06.2019.
 */
public interface MovingReportService {
    MovingReport addMovingReport(MovingReport movingReport);

    void delete(MovingReport movingReport);

    Optional<MovingReport> getById(long id);

    //    Receipt getByName(String name);
    List<MovingReport> getAll();
}
