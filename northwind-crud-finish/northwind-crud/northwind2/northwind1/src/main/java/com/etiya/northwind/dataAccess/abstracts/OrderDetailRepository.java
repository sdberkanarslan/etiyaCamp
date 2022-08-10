package com.etiya.northwind.dataAccess.abstracts;

import com.etiya.northwind.entities.concretes.OrderDetail;
import com.etiya.northwind.entities.concretes.OrderDetailsId;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailsId> {

}
