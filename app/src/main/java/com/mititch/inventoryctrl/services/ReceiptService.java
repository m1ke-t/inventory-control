package com.mititch.inventoryctrl.services;


import com.mititch.inventoryctrl.model.Receipt;

import java.util.List;
import java.util.Optional;

public interface ReceiptService {
    Receipt addReceipt(Receipt receipt);

    void delete(Receipt receipt);

    Optional<Receipt> getById(long id);

    //    Receipt getByName(String name);
    List<Receipt> getAll();
}
