package com.mititch.inventoryctrl.services;


import com.mititch.inventoryctrl.dao.repository.ReceiptRepository;
import com.mititch.inventoryctrl.model.Receipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;

    @Override
    public Receipt addReceipt(Receipt receipt) {
        return receiptRepository.save(receipt);
    }

    @Override
    public void delete(Receipt receipt) {
        receiptRepository.delete(receipt);
    }

    @Override
    public Optional<Receipt> getById(long id) {
        return receiptRepository.findById(id);
    }

//    @Override
//    public Receipt getByName(String name) {
//        return null;
//    }

    @Override
    public List<Receipt> getAll() {
        return (List<Receipt>) receiptRepository.findAll();
    }
}