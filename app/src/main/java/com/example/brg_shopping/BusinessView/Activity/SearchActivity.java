package com.example.brg_shopping.BusinessView.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brg_shopping.BusinessAdapter.CartAdapter;
import com.example.brg_shopping.BusinessAdapter.SearchCategoryAdapter;
import com.example.brg_shopping.BusinessAdapter.SearchProductionAdapter;
import com.example.brg_shopping.BusinessObject.CartInfo;
import com.example.brg_shopping.BusinessObject.CategoryInfo;
import com.example.brg_shopping.BusinessObject.CustomerInfo;
import com.example.brg_shopping.BusinessObject.ProductInfo;
import com.example.brg_shopping.BusinessService.CartService.CartService;
import com.example.brg_shopping.BusinessView.Fragment.CartListProductFragment;
import com.example.brg_shopping.R;
import com.example.brg_shopping.databinding.FragmentCardListProductBinding;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

    CustomerInfo customerInfo;
    ImageView imgBack;
    SearchView searchView;
    RecyclerView listCategoryResult;
    RecyclerView listProductionResult;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initVariable();
        setEvenListener();
        search("qq");
    }

    private void search(String query) {
        if (getApplicationContext().getResources().getString(R.string.BY_PASS).equals("true")) {
            List<ProductInfo> productInfoList = new ArrayList<>();
            for(int l=0; l<=5; l++){
                ProductInfo productInfo = new ProductInfo();
                productInfo.setProductID(l);
                productInfo.setProductName("Production");
                productInfo.setContent("magic");
                productInfo.setPrice(BigDecimal.valueOf(99.0));
                productInfo.setAmount(99);
                productInfoList.add(productInfo);
            }
            SearchProductionAdapter searchProductionAdapter = new SearchProductionAdapter(this, productInfoList);
            listProductionResult.setLayoutManager(new GridLayoutManager(this, 2));
            listProductionResult.setAdapter(searchProductionAdapter);
        } else {
            try {
                CartService.getInstance(getString(R.string.BASE_URL)).GetProductionSearch(query, new Callback<List<ProductInfo>>() {

                    @Override
                    public void onResponse(Call<List<ProductInfo>> call, Response<List<ProductInfo>> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        List<ProductInfo> productInfoList = response.body();

                        if (productInfoList.size() > 0) {
                            SearchProductionAdapter searchProductionAdapter = new SearchProductionAdapter((SearchActivity) getApplicationContext(), productInfoList);
                            listProductionResult.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
                            listProductionResult.setAdapter(searchProductionAdapter);
                        }

                    }

                    @Override
                    public void onFailure(Call<List<ProductInfo>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }catch (Exception e) {
                Toast.makeText(getApplicationContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void InsertToCart (ProductInfo item) {

        CartInfo cartInfo = new CartInfo();
        cartInfo.setCustomerID(customerInfo.getCustomerID());
        cartInfo.setProductID(item.getProductID());
        CartService.getInstance(getString(R.string.BASE_URL)).insertCart(cartInfo, new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Boolean result = response.body();
                if (result == true ){
                    Toast.makeText(getApplicationContext(), "Thêm vào giỏ hàng thành công " , Toast.LENGTH_SHORT ).show();
                }

            }


            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void handlerViewProductDetail(ProductInfo item) {
        Intent intent = new Intent(this, ProductActivity.class);
        intent.putExtra("ProductInfo" , item);
        intent.putExtra("customerInfo" , customerInfo);
        startActivity(intent);
    }

    private void setEvenListener() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                search(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // do nothing
                // can implement to real time search with current text
                return false;
            }
        });
    }

    private void initVariable() {
        customerInfo = (CustomerInfo) getIntent().getSerializableExtra("customerInfo");
        imgBack = findViewById(R.id.img_back);
        searchView = findViewById(R.id.search_view);
        listCategoryResult = findViewById(R.id.list_category_result);
        listProductionResult = findViewById(R.id.list_production_result);
    }
}
