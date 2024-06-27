package com.example.brg_shopping.BusinessService.CartService;

import com.example.brg_shopping.BusinessObject.CartInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiCartInterface {
    @POST("api/manager/Cart/insert")
    Call<Boolean> insertCart (@Body CartInfo infoInsert);
    @GET ("api/manager/Cart/get-product-customer")
    Call <List<CartInfo>> GetCartCustomer (@Query("CustomerID") int CustomerID);
}
