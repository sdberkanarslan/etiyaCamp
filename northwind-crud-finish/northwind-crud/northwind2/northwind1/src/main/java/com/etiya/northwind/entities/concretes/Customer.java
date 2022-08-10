package com.etiya.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @Column(name = "customer_id")
    private String customerId;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "contact_name")
    private String contactName;

    @OneToMany(mappedBy = "customer")
    private List<Order> orderList;

}
