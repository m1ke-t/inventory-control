package com.mititch.inventoryctrl.services;

import com.mititch.inventoryctrl.dao.repository.MovingReportRepository;
import com.mititch.inventoryctrl.model.MovingReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Mike S. on 27.06.2019.
 */
@Service
public class MovingReportServiceImpl implements MovingReportService {
    @Autowired
    private MovingReportRepository movingRepository;

    @Override
    public MovingReport addMovingReport(MovingReport movingReport) {
        return movingRepository.save(movingReport);
    }

    @Override
    public void delete(MovingReport receipt) {
        movingRepository.delete(receipt);
    }

    @Override
    public Optional<MovingReport> getById(long id) {
        return movingRepository.findById(id);
    }

//    @Override
//    public Receipt getByName(String name) {
//        return null;
//    }

    @Override
    public List<MovingReport> getAll() {
        return (List<MovingReport>) movingRepository.findAll();
    }
}
