package com.mititch.inventoryctrl.dto;

import com.mititch.inventoryctrl.model.MovingReport;
import com.mititch.inventoryctrl.model.Product;
import com.mititch.inventoryctrl.model.Receipt;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReceiptView {
    Receipt receipt;
    Product product;
    Integer amount;
    double price;
    MovingReport movingReport;
}