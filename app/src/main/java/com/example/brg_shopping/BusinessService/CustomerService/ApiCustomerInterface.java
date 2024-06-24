package com.example.brg_shopping.BusinessService.CustomerService;

import com.example.brg_shopping.BusinessObject.CustomerInfo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiCustomerInterface {
    @GET("api/manager/Customer/get-user")
    Call< CustomerInfo> getCustomerByUserName(@Query("userName") String userName);
    @POST("api/manager/Customer/insert")
    Call<Boolean> insertCustomer (@Body CustomerInfo infoInsert );
    @POST("api/manager/Customer/check-insert-phonenumber")
    Call<Boolean> CheckInsertPhoneNumber(@Body String phoneNumber);
}
