package com.mititch.inventoryctrl.services;

import com.mititch.inventoryctrl.model.Statement;

import java.util.List;
import java.util.Optional;

/**
 * Created by Mike S. on 27.06.2019.
 */
public interface StatementService {
    Statement addStatement(Statement statement);

    void delete(Statement statement);

    Optional<Statement> getById(long id);

    //    Receipt getByName(String name);
    List<Statement> getAll();
}
