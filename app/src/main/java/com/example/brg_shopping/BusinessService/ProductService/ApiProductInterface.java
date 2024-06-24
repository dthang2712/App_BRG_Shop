package com.example.brg_shopping.BusinessService.ProductService;

import com.example.brg_shopping.BusinessObject.ProductInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiProductInterface {
    @GET ("api/manager/Product/get-all")
    Call<List<ProductInfo>> GetAllProduct() ;
}
