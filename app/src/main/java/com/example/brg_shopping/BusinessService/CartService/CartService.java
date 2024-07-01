package com.example.brg_shopping.BusinessService.CartService;

import com.example.brg_shopping.BusinessObject.CartInfo;
import com.example.brg_shopping.BusinessObject.ProductInfo;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CartService {
    private String BASE_URL;
    private ApiCartInterface apiService;
    private static CartService instance;

    public CartService(String baseUrl) {
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
        apiService = retrofit.create(ApiCartInterface.class);
    }

    public static synchronized CartService getInstance(String baseUrl) {
        if (instance == null) {
            instance = new CartService(baseUrl);
        }
        return instance;
    }
    public void insertCart (CartInfo infoInsert , Callback<Boolean> callback){
        Call<Boolean> call = apiService.insertCart(infoInsert);
        call.enqueue(callback);
    }
    public  void GetCartCustomer (int CustomerID , Callback<List<CartInfo>> callback){
        Call<List<CartInfo>> call = apiService.GetCartCustomer(CustomerID);
        call.enqueue(callback);
    }
    public  void GetProductionSearch (String keyWord , Callback<List<ProductInfo>> callback){
        Call<List<ProductInfo>> call = apiService.GetProductionSearch(keyWord);
        call.enqueue(callback);
    }
}
