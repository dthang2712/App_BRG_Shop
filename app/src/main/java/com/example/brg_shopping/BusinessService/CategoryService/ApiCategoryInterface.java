package com.example.brg_shopping.BusinessService.CategoryService;

import com.example.brg_shopping.BusinessObject.CategoryInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCategoryInterface {
    @GET("api/manager/Category/get-all")
    Call<List<CategoryInfo>> GetAllCategory() ;
}
