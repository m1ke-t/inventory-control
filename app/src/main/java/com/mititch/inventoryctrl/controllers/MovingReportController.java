package com.mititch.inventoryctrl.controllers;

import com.mititch.inventoryctrl.model.MovingReport;
import com.mititch.inventoryctrl.model.Product;
import com.mititch.inventoryctrl.model.Receipt;
import com.mititch.inventoryctrl.model.TotalReport;
import com.mititch.inventoryctrl.services.MovingReportService;
import com.mititch.inventoryctrl.services.ProductService;
import com.mititch.inventoryctrl.services.ReceiptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * Created by Mike S. on 27.06.2019.
 */
@RestController
@Slf4j
public class MovingReportController {
    @Autowired
    private MovingReportService rs;
    @Autowired
    private ProductService ps;
    @Autowired
    private ReceiptService recs;

    @GetMapping(value = "getAll/movingReport")
    public List<MovingReport> getAll() {
        List<MovingReport> r = rs.getAll();

        return r;
    }

    @GetMapping(value = "/add/movingReport/{date}/{productId}/{amount}/{cost}/{documentId}")
    public String add(@PathVariable("date") String date,
                      @PathVariable("productId") long productId,
                      @PathVariable("amount") int amount,
                      @PathVariable("cost") double cost,
                      @PathVariable("documentId") long documentId) {

        Optional<Receipt> r = recs.getById(documentId);
        Optional<Product> p = ps.getById(productId);
        if (!r.isPresent() || !p.isPresent()) {
            return "Incorrect Input, please check documentId/productId";
        }

        MovingReport mr = rs.addMovingReport(new MovingReport(new Date(Long.parseLong(date)), productId, amount, cost, documentId, p.get(), r.get()));
        log.debug(mr.toString());
        return mr.toString();
    }

    @GetMapping(value = "/delete/movingReport/{id}")
    public void delete(@PathVariable("id") long id) {
        rs.delete(rs.getById(id).get());
    }

    @GetMapping(value = "/get/movingReport/{id}")
    public String getById(@PathVariable("id") long id) {
        //return rs.getById(id).get().toString();
        Optional<MovingReport> omr = rs.getById(id);
        System.out.println(omr.isPresent());
        MovingReport mr = omr.get();
        return mr.toString();
    }

    @GetMapping(value = "/get/statement/total/{from}/{to}")
    public ArrayList<TotalReport.Item> getTotal(@PathVariable("from") long from, @PathVariable("to") long to) {
        Date dateFrom = new Date(from);
        Date dateTo = new Date(to);
        HashMap<Long, TotalReport.Item> total = new TotalReport(rs.getAll(), dateFrom, dateTo).getTotalMap();
        return new ArrayList<>(total.values());
    }
}
