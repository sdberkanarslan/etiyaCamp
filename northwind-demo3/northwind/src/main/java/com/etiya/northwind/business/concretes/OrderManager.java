package com.etiya.northwind.business.concretes;


import com.etiya.northwind.business.abstracts.OrderService;
import com.etiya.northwind.business.requests.orders.CreateOrderRequest;
import com.etiya.northwind.business.requests.orders.DeleteOrderRequest;
import com.etiya.northwind.business.requests.orders.UpdateOrderRequest;
import com.etiya.northwind.business.responses.orders.GetOrderByIdResponse;
import com.etiya.northwind.business.responses.orders.OrderListResponse;
import com.etiya.northwind.core.results.DataResult;
import com.etiya.northwind.core.results.Result;
import com.etiya.northwind.core.results.SuccessDataResult;
import com.etiya.northwind.core.results.SuccessResult;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.OrderRepository;
import com.etiya.northwind.entities.concretes.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.image.RescaleOp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderManager implements OrderService {
    private OrderRepository orderRepository;
    private ModelMapperService modelMapperService;

    @Autowired
    public OrderManager(OrderRepository orderRepository,ModelMapperService modelMapperService) {
        this.modelMapperService=modelMapperService;
        this.orderRepository = orderRepository;
    }

    @Override
    public Result add(CreateOrderRequest createOrderRequest) {
        Order order=this.modelMapperService.forRequest().map(createOrderRequest, Order.class);
        this.orderRepository.save(order);

        return new SuccessResult("ORDER ADDED");

    }

    @Override
    public Result update(UpdateOrderRequest updateOrderRequest) {
        Order order=this.modelMapperService.forRequest().map(updateOrderRequest, Order.class);
        this.orderRepository.save(order);

        return new SuccessResult("ORDER UPDATED");

    }

    @Override
    public Result delete(DeleteOrderRequest deleteOrderRequest) {
        this.orderRepository.deleteById(deleteOrderRequest.getOrderId());

        return new SuccessResult("ORDER DELETED");


    }

    @Override
    public DataResult <GetOrderByIdResponse> getById(int id) {
        Order order=this.orderRepository.findById(id);
        GetOrderByIdResponse getOrderByIdResponse=this.modelMapperService.forResponse().map(order,GetOrderByIdResponse.class);

        return new SuccessDataResult<GetOrderByIdResponse>(getOrderByIdResponse);
    }

    @Override
    public DataResult <List<OrderListResponse>> getAll() {
        List<Order> result = this.orderRepository.findAll();
        List<OrderListResponse> responses = result.stream().map(order -> this.modelMapperService.forResponse().map(order,OrderListResponse.class)).collect(Collectors.toList());


        return new SuccessDataResult<List<OrderListResponse>>(responses);
    }

    @Override
    public Map<String, Object> getAllPages(int pageNumber, int pageSize) {
        Pageable pageable= PageRequest.of(pageNumber-1,pageSize);
        return pageableMap(pageable);
    }

    @Override
    public Map<String, Object> getAllPagesOrderByEntity(int pageNumber, int pageSize, String entity, String type) {
        Pageable pageable=PageRequest.of(pageNumber-1,pageSize,sortType(entity,type));
                  return   pageableMap(pageable);

    }

    private Map<String, Object> pageableMap(Pageable pageable){
         Map<String,Object> response=new HashMap<>();
        Page<Order>orders =orderRepository.findAll(pageable);
        response.put("totalElements",orders.getTotalElements()) ;
        response.put("totalPages",orders.getTotalPages());
        response.put("currentPage",orders.getNumber()+1);
        response.put("orders",orders.getContent().stream().map(order ->
                this.modelMapperService.forResponse().map(order,OrderListResponse.class)).collect(Collectors.toList()));

        return response ;
    }
    public Sort sortType(String property, String type){
        if(type.equals("desc"))
            return Sort.by(property).descending();
        else return Sort.by(property).ascending() ;

    }
    @Override
    public Order findById(int id) {
        Order order= this.orderRepository.findById(id);
        return order;
    }
}