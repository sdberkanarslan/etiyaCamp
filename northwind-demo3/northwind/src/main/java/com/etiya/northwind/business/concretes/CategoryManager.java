package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.CategoryService;
import com.etiya.northwind.business.requests.categories.CreateCategoryRequest;
import com.etiya.northwind.business.requests.categories.DeleteCategoryRequest;
import com.etiya.northwind.business.requests.categories.UpdateCategoryRequest;
import com.etiya.northwind.business.responses.categories.CategoryListResponse;
import com.etiya.northwind.business.responses.categories.GetCategoryByIdResponse;
import com.etiya.northwind.core.exceptions.BusinessException;
import com.etiya.northwind.core.results.DataResult;
import com.etiya.northwind.core.results.Result;
import com.etiya.northwind.core.results.SuccessDataResult;
import com.etiya.northwind.core.results.SuccessResult;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.CategoryRepository;
import com.etiya.northwind.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class CategoryManager implements CategoryService {
    private CategoryRepository categoryRepository;
    private ModelMapperService modelMapperService;

    @Autowired
    public CategoryManager(CategoryRepository categoryRepository,ModelMapperService modelMapperService) {
        this.categoryRepository = categoryRepository;
        this.modelMapperService=modelMapperService;
    }

    @Override
    public Result add(CreateCategoryRequest createCategoryRequest) {
        checkIfCategoryNameExist(createCategoryRequest.getCategoryName());
        Category category=this.modelMapperService.forRequest().map(createCategoryRequest,Category.class);
        categoryRepository.save(category);
        return new SuccessResult("CATEGORY ADDED");
    }

    @Override
    public Result update(UpdateCategoryRequest updateCategoryRequest) {
        checkIfCategoryNameExist(updateCategoryRequest.getCategoryName());
      Category category=this.modelMapperService.forRequest().map(updateCategoryRequest,Category.class);
      categoryRepository.save(category);
        return new SuccessResult("CATEGORY UPDATED");

    }

    @Override
    public Result delete(DeleteCategoryRequest deleteCategoryRequest) {
        categoryRepository.deleteById(deleteCategoryRequest.getCategoryId());
        return new SuccessResult("CATEGORY DELETED");

    }

    @Override
    public DataResult<GetCategoryByIdResponse> getById(int id) {
        Category category=this.categoryRepository.findById(id);
        GetCategoryByIdResponse getCategoryByIdResponse=this.modelMapperService.forResponse().map(category,GetCategoryByIdResponse.class);

        return new SuccessDataResult<GetCategoryByIdResponse>(getCategoryByIdResponse);
    }

    @Override
    public DataResult<List<CategoryListResponse>> getAll() {
        List<Category> result = this.categoryRepository.findAll();
        List<CategoryListResponse> responses = result.stream().map(category->this.modelMapperService.forResponse()
                .map(category, CategoryListResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<CategoryListResponse>>(responses);
    }


    @Override
    public Map<String, Object> getAllPages(int pageNumber, int pageSize) {
        Pageable pageable=PageRequest.of(pageNumber-1,pageSize);
        Map<String,Object> response=new HashMap<>();

        Page<Category>categories =categoryRepository.findAll(pageable);
        response.put("totalElements",categories.getTotalElements()) ;
        response.put("totalPages",categories.getTotalPages());
        response.put("currentPage",categories.getNumber()+1);
        response.put("categories",categories.getContent().stream().map(category ->
                this.modelMapperService.forResponse().map(category,CategoryListResponse.class)).collect(Collectors.toList()));

        return response ;
    }

    @Override
    public Map<String, Object> getAllPagesOrderByEntity(int pageNumber, int pageSize,String entity,String type) {
        Pageable pageable=PageRequest.of(pageNumber-1,pageSize,sortType(entity,type));


        Map<String,Object> response=new HashMap<>();
        Page<Category>categories =categoryRepository.findAll(pageable);
        response.put("totalElements",categories.getTotalElements()) ;
        response.put("totalPages",categories.getTotalPages());
        response.put("currentPage",categories.getNumber()+1);
        response.put("categories",categories.getContent().stream().map(category ->
                this.modelMapperService.forResponse().map(category,CategoryListResponse.class)).collect(Collectors.toList()));

        return response ;
    }

    public Sort sortType(String property,String type){
        if(type.equals("desc"))
            return Sort.by(property).descending();
        else return Sort.by(property).ascending() ;

    }

    private void checkIfCategoryNameExist(String name) {
        Category category = categoryRepository.findByCategoryName(name);
        if(category != null) {
            throw new BusinessException("CategoryName Exist");
        }
    }


    private void checkIfCategoryIdExist(int id) {
        Category category = categoryRepository.findByCategoryId(id);
        if (category != null) {
            throw new BusinessException("CategoryId Exist");
        }
    }

}
