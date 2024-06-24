package com.example.brg_shopping.BusinessService.CustomerService;

import com.example.brg_shopping.BusinessObject.CustomerInfo;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CustomerService {
    private String BASE_URL;
    private ApiCustomerInterface apiService;
    private static CustomerService instance;

    public static synchronized CustomerService getInstance(String baseUrl) {
        if (instance == null) {
            instance = new CustomerService(baseUrl);
        }
        return instance;
    }

    public CustomerService(String baseUrl) {
        this.BASE_URL = baseUrl;

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
// set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
// add your other interceptors …
// add logging as last interceptor
        httpClient.addInterceptor(logging);  // <-- this is the important line!

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ApiCustomerInterface.class);
    }

    public void getCustomerByPhoneNumber(String PhoneNumber, Callback<CustomerInfo> callback) {
        Call<CustomerInfo> call = apiService.getCustomerByUserName(PhoneNumber);
        call.enqueue(callback);
    }

    public void insertCustomer(CustomerInfo infoInsert, Callback<Boolean> callback) {
        Call<Boolean> call = apiService.insertCustomer(infoInsert);
        call.enqueue(callback);
    }
    public void CheckInsertPhoneNumber (String PhoneNumber , Callback<Boolean> callback){
        Call<Boolean> call = apiService.CheckInsertPhoneNumber( PhoneNumber);
        call.enqueue(callback);
    }
}
