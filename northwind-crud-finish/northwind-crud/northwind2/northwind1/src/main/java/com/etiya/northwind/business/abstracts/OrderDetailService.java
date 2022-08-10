package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.order.CreateOrderDetailRequest;
import com.etiya.northwind.business.responses.order.OrderDetailListResponse;
import com.etiya.northwind.business.requests.order.UpdateOrderDetailRequest;
import com.etiya.northwind.entities.concretes.OrderDetailsId;

import java.util.List;
import java.util.Map;

public interface OrderDetailService {
    List<OrderDetailListResponse> getAlL();

    OrderDetailListResponse getOrderDetailById(Integer orderId, Integer productId);

    OrderDetailListResponse createOrderDetail(CreateOrderDetailRequest createOrderDetailRequest);


    void deleteOrderDetailById(Integer orderId, Integer productId);

    OrderDetailListResponse updateOrderDetail(OrderDetailsId orderDetailsId, UpdateOrderDetailRequest updateOrderDetailRequest);

    Map<String, Object> findByPageable(int page, int size);

    Map<String, Object> getAllPagesOrderByEntity(int pageNumber, int pageSize, String property, String orElse);
}
