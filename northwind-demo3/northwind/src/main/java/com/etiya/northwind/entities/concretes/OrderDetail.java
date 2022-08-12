package com.etiya.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_details")
@IdClass(OrderDetailId.class)
public class OrderDetail {

    @Id
    private int orderId;

    @Id
    private int productId;

    @Column(name="unit_price")
    private double unitPrice;
    @Column(name="quantity")
    private int quantity;
    @Column(name="discount")
    private double discount;
}
