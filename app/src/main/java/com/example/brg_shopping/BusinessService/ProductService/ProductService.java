package com.example.brg_shopping.BusinessService.ProductService;

import com.example.brg_shopping.BusinessObject.ProductInfo;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductService {
    private String BASE_URL;
    private ApiProductInterface apiService;
    private static ProductService instance;

    public static synchronized ProductService getInstance(String baseUrl) {
        if (instance == null) {
            instance = new ProductService(baseUrl);
        }
        return instance;
    }

    public ProductService(String baseUrl) {
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
        apiService = retrofit.create(ApiProductInterface.class);
    }
    public void GetAllProduct (Callback<List<ProductInfo>> callback){
        Call<List<ProductInfo>> call = apiService.GetAllProduct();
        call.enqueue(callback);
    }
}
