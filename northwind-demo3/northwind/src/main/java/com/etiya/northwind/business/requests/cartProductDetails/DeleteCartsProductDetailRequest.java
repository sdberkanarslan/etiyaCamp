package com.etiya.northwind.business.requests.cartProductDetails;

import com.etiya.northwind.entities.concretes.CartProductDetailId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteCartsProductDetailRequest {

    private CartProductDetailId cartProductDetailId;
}
