package com.etiya.northwind.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="suppliers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id" )
    private Integer supplierId;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "contact_name")
    private String contactName;

    @OneToMany(mappedBy = "supplier")
    private List<Product> productList;






}
