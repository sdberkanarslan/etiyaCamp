package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.orderDetails.CreateOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.DeleteOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.UpdateOrderDetailRequest;
import com.etiya.northwind.business.responses.orderDetails.GetOrderDetailByIdResponse;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailListResponse;
import com.etiya.northwind.core.results.DataResult;
import com.etiya.northwind.core.results.Result;

import java.util.List;
import java.util.Map;

public interface OrderDetailService {
    Result add(CreateOrderDetailRequest createOrderDetailReqest);
    Result update(UpdateOrderDetailRequest updateOrderDetailRequest);
    Result delete(DeleteOrderDetailRequest deleteOrderDetailrequest);

    DataResult <GetOrderDetailByIdResponse> getById(int orderId, int productId);

    DataResult <List<OrderDetailListResponse>> getAll();

    Map<String,Object> getAllPages(int pageNumber, int pageSize);

    Map<String,Object>getAllPagesOrderByEntity(int pageNumber, int pageSize,String entity,String type);
}
