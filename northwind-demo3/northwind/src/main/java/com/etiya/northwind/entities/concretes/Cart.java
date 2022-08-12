package com.etiya.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id" )
    private int cartId;
    @Column(name = "product_id")
    private int productId;
    @Column(name="unit_price")
    private double unitPrice;
    @Column(name="quantity")
    private int quantity;


    @ManyToOne
    @JoinColumn(name = "cart_product_detail_id")
    private CartProductDetail cartProductDetail;


}
