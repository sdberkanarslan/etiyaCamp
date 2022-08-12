package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.OrderDetailService;
import com.etiya.northwind.business.abstracts.OrderService;
import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.requests.orderDetails.CreateOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.DeleteOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.UpdateOrderDetailRequest;
import com.etiya.northwind.business.responses.orderDetails.GetOrderDetailByIdResponse;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailListResponse;
import com.etiya.northwind.core.results.DataResult;
import com.etiya.northwind.core.results.Result;
import com.etiya.northwind.core.results.SuccessDataResult;
import com.etiya.northwind.core.results.SuccessResult;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.OrderDetailRepository;
import com.etiya.northwind.entities.concretes.Order;
import com.etiya.northwind.entities.concretes.OrderDetail;
import com.etiya.northwind.entities.concretes.OrderDetailId;
import com.etiya.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderDetailManager implements OrderDetailService {

    private OrderDetailRepository orderDetailRepository;
    private ModelMapperService modelMapperService;
    private final OrderService orderService;
    private final ProductService productService;

    @Autowired
    public OrderDetailManager(OrderDetailRepository orderDetailRepository, ModelMapperService modelMapperService, OrderService orderService, ProductService productService) {
        this.orderDetailRepository = orderDetailRepository;
        this.modelMapperService=modelMapperService;
        this.orderService = orderService;
        this.productService = productService;
    }

    @Override
    public Result add(CreateOrderDetailRequest createOrderDetailReqest) {

        OrderDetail orderDetail=this.modelMapperService.forRequest().map(createOrderDetailReqest,OrderDetail.class);
        this.orderDetailRepository.save(orderDetail);

        return new SuccessResult("ORDER DETAIL ADDED");

    }

    @Override
    public Result update(UpdateOrderDetailRequest updateOrderDetailRequest) {
        OrderDetail orderDetail=this.modelMapperService.forRequest().map(updateOrderDetailRequest,OrderDetail.class);
        this.orderDetailRepository.save(orderDetail);

        return new SuccessResult("ORDER DETAIL UPDATED");

    }

    @Override
    public Result delete(DeleteOrderDetailRequest deleteOrderDetailRequest) {
        this.orderDetailRepository.deleteById(deleteOrderDetailRequest.getOrderDetailId());

        return new SuccessResult("ORDER DETAIL DELETED");


    }

    @Override
    public DataResult <GetOrderDetailByIdResponse> getById(int orderId, int productId) {
        OrderDetail orderDetail = this.orderDetailRepository.findById(createOrderDetailId(orderId, productId)).get();

        return new SuccessDataResult<GetOrderDetailByIdResponse>(orderDetailMapping(orderId, productId, orderDetail));
    }


    @Override
    public DataResult <List<OrderDetailListResponse>> getAll() {
        List<OrderDetail> result = this.orderDetailRepository.findAll();
        List<OrderDetailListResponse> response =result.stream().map(orderDetail ->
                orderDetailMappingList(orderDetail.getOrderId(), orderDetail.getProductId(), orderDetail)).collect(Collectors.toList());

        return new SuccessDataResult<List<OrderDetailListResponse>>(response);
    }


    private GetOrderDetailByIdResponse orderDetailMapping(int orderId, int productId, OrderDetail orderDetail) {
        GetOrderDetailByIdResponse getOrderDetailByIdResponse = this.modelMapperService.forResponse().map(orderDetail, GetOrderDetailByIdResponse.class);
        Order order = this.orderService.findById(orderId);
        Product product = this.productService.findById(productId);
        getOrderDetailByIdResponse.setContactName(order.getCustomer().getContactName());
        getOrderDetailByIdResponse.setOrderDate(order.getOrderDate());
        getOrderDetailByIdResponse.setProductName(product.getProductName());
        return getOrderDetailByIdResponse;
    }
    private OrderDetailListResponse orderDetailMappingList(int orderId, int productId, OrderDetail orderDetail) {
        OrderDetailListResponse orderDetailListResponse = this.modelMapperService.forResponse()
                .map(orderDetail, OrderDetailListResponse.class);
        Order order = this.orderService.findById(orderId);
        Product product = this.productService.findById(productId);
        orderDetailListResponse.setContactName(order.getCustomer().getContactName());
        orderDetailListResponse.setOrderDate(order.getOrderDate());
        orderDetailListResponse.setProductName(product.getProductName());
        return orderDetailListResponse;
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
        Page<OrderDetail> orderDetails =orderDetailRepository.findAll(pageable);
        response.put("totalElements",orderDetails.getTotalElements()) ;
        response.put("totalPages",orderDetails.getTotalPages());
        response.put("currentPage",orderDetails.getNumber()+1);
        response.put("orderDetail",orderDetails.getContent().stream().map(orderDetail ->
                this.modelMapperService.forResponse().map(orderDetail, OrderDetailListResponse.class)).collect(Collectors.toList()));

        return response ;
    }
    public Sort sortType(String property, String type){
        if(type.equals("desc"))
            return Sort.by(property).descending();
        else return Sort.by(property).ascending() ;

    }

    private OrderDetailId createOrderDetailId(int orderId, int productId) {
        OrderDetailId orderDetailId = new OrderDetailId();
        orderDetailId.setOrderId(orderId);
        orderDetailId.setProductId(productId);
        return orderDetailId;
    }
}