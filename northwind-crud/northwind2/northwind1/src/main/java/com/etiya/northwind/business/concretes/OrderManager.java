package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.OrderService;
import com.etiya.northwind.business.responses.OrderDetailListResponse;
import com.etiya.northwind.business.responses.OrderListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.OrderRepository;
import com.etiya.northwind.entities.concretes.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderManager implements OrderService {


    private final OrderRepository orderRepository;
    private final ModelMapperService modelMapperService;

    public OrderManager(OrderRepository orderRepository, ModelMapperService modelMapperService) {
        this.orderRepository = orderRepository;
        this.modelMapperService = modelMapperService;
    }


    @Override
    public List<OrderListResponse> getAlL() {
        List<Order> result =  this.orderRepository.findAll();
        List<OrderListResponse> response = result
                .stream()
                .map(order -> this.modelMapperService.forResponse().map(order, OrderListResponse.class))
                .collect(Collectors.toList());

        for (int i = 0; i < result.size(); i++) {
            response.get(i)
                    .setEmployeeName(result.get(i).getEmployee().getFirstName()
                            + " " + result.get(i).getEmployee().getLastName());

            response.get(i)
                    .setCustomerName(result.get(i).getCustomer().getCompanyName()
                            + " and " + result.get(i).getCustomer().getContactName());
        }
        return response;
    }
}
