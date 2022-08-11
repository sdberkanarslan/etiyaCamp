package com.etiya.northwind.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "order_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(OrderDetailsId.class)
public class OrderDetail{
    @Id
    private Integer orderId;

    @Id
    private Integer productId;

/*    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;*/

    @Column(name = "unit_price")
    private int unitPrice;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "discount")
    private int discount;



}
