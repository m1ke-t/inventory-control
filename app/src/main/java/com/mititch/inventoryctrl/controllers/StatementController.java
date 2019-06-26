package com.mititch.inventoryctrl.controllers;

import com.mititch.inventoryctrl.model.Statement;
import com.mititch.inventoryctrl.services.StatementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

/**
 * Created by Mike S. on 27.06.2019.
 */
@RestController
@Slf4j
public class StatementController {
    @Autowired
    private StatementService rs;

    @GetMapping(value = "getAll/statement")
    public List<Statement> getAll() {
        List<Statement> r = rs.getAll();
        for (Statement statement : r) {
            log.debug(statement.toString());
        }
        return rs.getAll();
    }

    @GetMapping(value = "/add/statement/{date}{accounting}")
    public String add(@PathVariable("date") Date date, @PathVariable("accounting") boolean acc) {
//        Receipt r = rs.addStatement(new Statement(date,acc));
//        log.debug(r.toString());
        return "Not Allowed";
    }

    @GetMapping(value = "/delete/statement/{id}")
    public void delete(@PathVariable("id") long id) {
        rs.delete(rs.getById(id).get());
    }

    @GetMapping(value = "/get/statement/{id}")
    public Statement getById(@PathVariable("id") long id) {
        return rs.getById(id).get();
    }
}
