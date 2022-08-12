package com.etiya.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cartProductDetails")
public class CartProductDetail {
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)                   //?? cart_id...detail_id
    @Column(name = "cart_product_detail_id")
    private int cartProductDetailId;
*/

    @Id
    @Column(name = "order_id")
    private int orderId;

    @Id
    @Column(name = "product_id")
    private int productId;


 /*  @OneToMany(mappedBy = "cartProductDetail")
    private List<Cart> carts;

    @OneToMany(mappedBy = "cartProductDetail")
    private List<Product> products;*/

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Order order;

}

