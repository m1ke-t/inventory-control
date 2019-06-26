package com.mititch.inventoryctrl.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "receipt")
public class Receipt {

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", date=" + date +
                ", accountingEntry=" + accountingEntry +
                '}';
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "acc_entry")
    private boolean accountingEntry;

    public Receipt(Date date, boolean accountingEntry) {
        this.date = date;
        this.accountingEntry = accountingEntry;
    }
}