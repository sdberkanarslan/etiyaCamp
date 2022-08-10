package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.OrderDetailService;
import com.etiya.northwind.business.responses.EmployeeListResponse;
import com.etiya.northwind.business.responses.OrderDetailListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.OrderDetailRepository;
import com.etiya.northwind.entities.concretes.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailManager implements OrderDetailService {


    private final OrderDetailRepository orderDetailRepository;
    private final ModelMapperService modelMapperService;

    public OrderDetailManager(OrderDetailRepository orderDetailRepository, ModelMapperService modelMapperService) {
        this.orderDetailRepository = orderDetailRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<OrderDetailListResponse> getAlL() {
        List<OrderDetail> result = this.orderDetailRepository.findAll();
        List<OrderDetailListResponse> response = result
                .stream()
                .map(orderDetail -> this.modelMapperService.forResponse().map(orderDetail, OrderDetailListResponse.class))
                .collect(Collectors.toList());
        return response;
    }
}
