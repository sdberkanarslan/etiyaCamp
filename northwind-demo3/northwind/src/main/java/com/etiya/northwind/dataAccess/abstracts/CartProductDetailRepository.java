package com.etiya.northwind.dataAccess.abstracts;

import com.etiya.northwind.entities.concretes.CartProductDetail;
import com.etiya.northwind.entities.concretes.CartProductDetailId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductDetailRepository extends JpaRepository <CartProductDetail, CartProductDetailId> {

    CartProductDetail getByCartProductDetail_CartProductDetailIdAndCart_CartId(int cartId,int productId);

}
