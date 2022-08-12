package com.etiya.northwind.entities.concretes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class Customer {
    @Id
    @Column(name = "customer_id")
    private String customerId;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "contact_name")
    private String contactName;
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name ="city_id")
    private City city;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;



}
