package com.mititch.inventoryctrl.services;

import com.mititch.inventoryctrl.dao.repository.StatementRepository;
import com.mititch.inventoryctrl.model.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Mike S. on 27.06.2019.
 */
@Service
public class StatementServiceImpl implements StatementService {

    @Autowired
    private StatementRepository statementRepository;

    @Override
    public Statement addStatement(Statement receipt) {
        return statementRepository.save(receipt);
    }

    @Override
    public void delete(Statement statement) {
        statementRepository.delete(statement);
    }

    @Override
    public Optional<Statement> getById(long id) {
        return statementRepository.findById(id);
    }

//    @Override
//    public Receipt getByName(String name) {
//        return null;
//    }

    @Override
    public List<Statement> getAll() {
        return (List<Statement>) statementRepository.findAll();
    }
}
