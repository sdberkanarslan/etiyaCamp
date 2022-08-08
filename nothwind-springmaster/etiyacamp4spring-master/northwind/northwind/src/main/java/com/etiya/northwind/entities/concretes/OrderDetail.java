package com.etiya.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "order_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderDetailId;


    @OneToOne
    //@JoinColumn(name = "order_id")
    @PrimaryKeyJoinColumn
    private Order order;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "unit_price")
    private int unitPrice;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "discount")
    private int discount;



}
