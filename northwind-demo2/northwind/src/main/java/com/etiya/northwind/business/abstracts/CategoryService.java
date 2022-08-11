package com.etiya.northwind.business.abstracts;


import com.etiya.northwind.business.requests.categories.CreateCategoryRequest;
import com.etiya.northwind.business.requests.categories.DeleteCategoryRequest;
import com.etiya.northwind.business.requests.categories.UpdateCategoryRequest;
import com.etiya.northwind.business.responses.categories.CategoryListResponse;
import com.etiya.northwind.business.responses.categories.GetCategoryByIdResponse;
import com.etiya.northwind.core.results.DataResult;
import com.etiya.northwind.core.results.Result;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;

public interface CategoryService {
    Result add(CreateCategoryRequest createCategoryRequest);
    Result update(UpdateCategoryRequest updateCategoryRequest);
    Result delete(DeleteCategoryRequest deleteCategoryRequest);

    DataResult <GetCategoryByIdResponse> getById(int id);

    DataResult <List<CategoryListResponse>> getAll();
    Map<String,Object> getAllPages(int pageNumber, int pageSize);
    Map<String,Object>getAllPagesOrderByEntity(int pageNumber, int pageSize,String entity,String type);


}
