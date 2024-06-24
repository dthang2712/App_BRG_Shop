package com.example.brg_shopping.BusinessService.CategoryService;

import com.example.brg_shopping.BusinessObject.CategoryInfo;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CategoryService {
    private String BASE_URL;
    private ApiCategoryInterface apiService;
    private static CategoryService instance;

    public static synchronized CategoryService getInstance(String baseUrl) {
        if (instance == null) {
            instance = new CategoryService(baseUrl);
        }
        return instance;
    }

    public CategoryService(String baseUrl) {
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
        apiService = retrofit.create(ApiCategoryInterface.class);
    }
    public void GetAllCategory (Callback<List<CategoryInfo>> callback){
        Call<List<CategoryInfo>> call = apiService.GetAllCategory();
        call.enqueue(callback);
    }
}
