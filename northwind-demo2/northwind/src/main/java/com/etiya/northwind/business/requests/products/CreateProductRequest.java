package com.etiya.northwind.business.requests.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {
    private int productId;
    private int supplierId;
    private int categoryId;

    @NotNull
    @NotBlank
    @Size(min=1,max=10)
    private String productName;
    private int discontinued;
}
