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
@Table(name = "prod_moving")
public class MovingReport {


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private long id;

    @Column(name = "date")
    Date date;

//    @Column(name = "product")
//    long productId;

    @Column(name = "amount")
    int amount;

    @Column(name = "cost")
    double cost;

//    @Column(name = "document")
//    long document;

    @JoinColumn(name = "product", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Product product;

    @JoinColumn(name = "document", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Receipt receipt;

    @Override
    public String toString() {
        return "MovingReport{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", cost=" + cost +
                ", product=" + product +
                ", receipt=" + receipt +
                '}';
    }

    public MovingReport(Date date, long productId, int amount, double cost, long document, Product product, Receipt receipt) {
        this.date = date;
        //this.productId = productId;
        this.amount = amount;
        this.cost = cost;
        //this.document = document;
        this.product = product;
        this.receipt = receipt;
    }
}

 