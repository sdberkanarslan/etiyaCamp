package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.CategoryService;
import com.etiya.northwind.business.requests.categories.CreateCategoryRequest;
import com.etiya.northwind.business.requests.categories.DeleteCategoryRequest;
import com.etiya.northwind.business.requests.categories.UpdateCategoryRequest;
import com.etiya.northwind.business.responses.categories.CategoryListResponse;
import com.etiya.northwind.business.responses.categories.GetCategoryByIdResponse;
import com.etiya.northwind.core.results.DataResult;
import com.etiya.northwind.core.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
    private CategoryService categoryService;

    @Autowired
    public CategoriesController(CategoryService categoryService) {

        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody CreateCategoryRequest createCategoryRequest){
       return this.categoryService.add(createCategoryRequest);

    }

    @PostMapping("/update")
    public Result update(@RequestBody UpdateCategoryRequest updateCategoryRequest){
        return  this.categoryService.update(updateCategoryRequest);

    }
    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteCategoryRequest deleteCategoryRequest){
        return this.categoryService.delete(deleteCategoryRequest);
    }


    @GetMapping("/getAll")
    public DataResult <List<CategoryListResponse>> getAll() {

        return this.categoryService.getAll();
    }
    @GetMapping("/getbyid")
    public DataResult <GetCategoryByIdResponse> getById(@RequestParam int id){

        return this.categoryService.getById(id);
    }

    @GetMapping("/getallpages")
    public Map<String,Object> getAllPages(@RequestParam int pageNumber,@RequestParam int pageSize){

        return this.categoryService.getAllPages(pageNumber,pageSize);

    }

    @GetMapping("/getallpagesorderbyentity")
    public Map<String,Object> getAllPagesOrderByEntity(@RequestParam int pageNumber,@RequestParam int pageSize,@RequestParam String entity,@RequestParam Optional<String> type){

        return this.categoryService.getAllPagesOrderByEntity(pageNumber,pageSize, entity,type.orElse(""));

    }

}