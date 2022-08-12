package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.CartProductDetailService;
import com.etiya.northwind.business.requests.cartProductDetails.CreateCartsProductDetailRequest;
import com.etiya.northwind.business.requests.cartProductDetails.DeleteCartsProductDetailRequest;
import com.etiya.northwind.business.requests.cartProductDetails.UpdateCartsProductDetailRequest;
import com.etiya.northwind.business.responses.carts.GetCartsByIdResponce;
import com.etiya.northwind.core.results.DataResult;
import com.etiya.northwind.core.results.Result;
import com.etiya.northwind.core.results.SuccessDataResult;
import com.etiya.northwind.core.results.SuccessResult;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.CartProductDetailRepository;
import com.etiya.northwind.entities.concretes.CartProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartProductDetailManager implements CartProductDetailService {


    private CartProductDetailRepository cartProductDetailRepository;
    private ModelMapperService modelMapperService;



    public CartProductDetailManager(CartProductDetailRepository cartProductDetailRepository, ModelMapperService modelMapperService) {
        this.cartProductDetailRepository = cartProductDetailRepository;
        this.modelMapperService = modelMapperService;
    }


    @Override
    public Result add(CreateCartsProductDetailRequest createCartsProductDetailRequest) {
        CartProductDetail cartProductDetail = this.modelMapperService.forRequest().map(createCartsProductDetailRequest, CartProductDetail.class);
        this.cartProductDetailRepository.save(cartProductDetail);
        return new SuccessResult("PRODUCT ADDED TO CART");
    }

    @Override
    public Result delete(DeleteCartsProductDetailRequest deleteCartsProductDetailRequest) {
       /* CartProductDetail cartProductDetail = this.cartProductDetailRepository.getByCartProductDetail_CartProductDetailIdAndCart_CartId();
        cartProductDetail.delete*/
        CartProductDetail cartProductDetail = this.modelMapperService.forRequest().map(deleteCartsProductDetailRequest,CartProductDetail.class);
        this.cartProductDetailRepository.deleteById(deleteCartsProductDetailRequest.getCartProductDetailId());
        return new SuccessResult("PRODUCT DELETED FROM CART");

    }

    @Override
    public Result update(UpdateCartsProductDetailRequest updateCartsProductDetailRequest) {
        CartProductDetail cartProductDetail = this.modelMapperService.forRequest().map(updateCartsProductDetailRequest, CartProductDetail.class);
        this.cartProductDetailRepository.save(cartProductDetail);
        return new SuccessResult("PRODUCT UPDATED IN CART");
    }


    @Override
    public DataResult<GetCartsByIdResponce> getById(int cartId, int productId) {
        CartProductDetail cartProductDetail = this.cartProductDetailRepository.getByCartProductDetail_CartProductDetailIdAndCart_CartId(cartId, productId);
        GetCartsByIdResponce getCartsByIdResponce = this.modelMapperService.forResponse()
                .map(cartProductDetail, GetCartsByIdResponce.class);
        return new SuccessDataResult<>(getCartsByIdResponce);
    }

}
