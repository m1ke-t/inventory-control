package com.mititch.inventoryctrl.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "receiptv")
public class Statement {

    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "id")
    private long id;

//    @Column(name = "product")
//    private long productId;

    @Column(name = "amount")
    private int amount;

    @Column(name = "price")
    private int price;

//    @Column (name = "document")
//    private long documentId;

    @JoinColumn(name = "product", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Product product;

    @JoinColumn(name = "document", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Receipt receipt;

    @Override
    public String toString() {
        return "Statement{" +
                "id=" + id +
                ", amount=" + amount +
                ", price=" + price +
                ", product=" + product +
                ", receipt=" + receipt +
                '}';
    }
}

 