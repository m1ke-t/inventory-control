package com.mititch.inventoryctrl.controllers;

import com.mititch.inventoryctrl.model.Receipt;
import com.mititch.inventoryctrl.services.ReceiptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@Slf4j

public class ReceiptController {
    @Autowired
    private ReceiptService rs;

    @GetMapping(value = "getAll/receipt")
    public List<Receipt> getAll() {
        List<Receipt> r = rs.getAll();
        for (Receipt receipt : r) {
            log.debug(receipt.toString());
        }
        return rs.getAll();
    }

    @GetMapping(value = "/add/receipt/{date}/{accounting}")
    public Receipt add(@PathVariable("date") long date, @PathVariable("accounting") boolean acc) {
        Receipt r = rs.addReceipt(new Receipt(new Date(date), acc));
        log.debug(r.toString());
        return r;
    }

    @GetMapping(value = "/delete/receipt/{id}")
    public void delete(@PathVariable("id") long id) {
        rs.delete(rs.getById(id).get());
    }

    @GetMapping(value = "/get/receipt/{id}")
    public Receipt getById(@PathVariable("id") long id) {
        return rs.getById(id).get();
    }
}
