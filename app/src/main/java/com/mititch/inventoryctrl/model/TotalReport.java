package com.mititch.inventoryctrl.model;

import lombok.Getter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mike S. on 27.06.2019.
 */
public class TotalReport {
    public HashMap<Long, Item> getTotalMap() {
        return totalMap;
    }

    private HashMap<Long, Item> totalMap = new HashMap<>();

    @Getter
    public class Item {
        String product;
        Integer amount_begin;
        Integer amount_end;
        Integer receipt_amount;

        Double receipt_cost;
        Double cost_begin;
        Double cost_end;

        Item(Product product) {
            this.product = product.getName();
            this.amount_begin = 0;
            this.amount_end = 0;
            this.receipt_amount = 0;
            this.receipt_cost = 0.0;
            this.cost_begin = 0.0;
            this.cost_end = 0.0;
        }
    }

    ArrayList<Item> result = new ArrayList<>();

    public TotalReport(List<MovingReport> s, Date from, Date to) {
        for (MovingReport movingReport : s) {
            totalMap.put(movingReport.getProduct().getId(),
                    new Item(movingReport.getProduct()));
        }
        for (MovingReport movingReport : s) {
            if (movingReport.date.before(from)) {
                Item i = totalMap.get(movingReport.getProduct().getId());
                i.amount_begin += movingReport.amount;
                i.cost_begin += movingReport.cost * movingReport.amount;
                totalMap.put(movingReport.getProduct().getId(), i);
            }
        }

        for (MovingReport movingReport : s) {
            if (movingReport.date.before(to) && movingReport.date.after(from)) {
                Item i = totalMap.get(movingReport.getProduct().getId());
                i.amount_end += movingReport.amount;
                i.cost_end += movingReport.cost * movingReport.amount;
                totalMap.put(movingReport.getProduct().getId(), i);
            }
        }

        for (Map.Entry<Long, Item> entry : totalMap.entrySet()) {
            Item i = entry.getValue();
            i.receipt_amount = i.amount_end - i.amount_begin;
            i.receipt_cost = i.cost_end - i.cost_begin;
            entry.setValue(i);
        }

    }
}
