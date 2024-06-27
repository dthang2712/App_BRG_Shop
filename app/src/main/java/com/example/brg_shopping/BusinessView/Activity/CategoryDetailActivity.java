package com.example.brg_shopping.BusinessView.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brg_shopping.BusinessAdapter.CategoryDetailAdapter;
import com.example.brg_shopping.BusinessObject.CartInfo;
import com.example.brg_shopping.BusinessObject.CategoryInfo;
import com.example.brg_shopping.BusinessObject.CustomerInfo;
import com.example.brg_shopping.BusinessObject.ProductInfo;
import com.example.brg_shopping.BusinessService.CartService.CartService;
import com.example.brg_shopping.BusinessService.ProductService.ProductService;
import com.example.brg_shopping.R;
import com.example.brg_shopping.databinding.ActivityCategoryDetailBinding;
import com.example.brg_shopping.databinding.DesignListProductDetailBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryDetailActivity extends AppCompatActivity {

    private ActivityCategoryDetailBinding binding;
    CategoryInfo categoryInfo ;
    ProductInfo productInfo ;

    CustomerInfo customerInfo;
    Button btn_back ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);

        categoryInfo = (CategoryInfo) getIntent().getSerializableExtra("categoryInfo");


        binding = ActivityCategoryDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.listCartInfo.setLayoutManager(new GridLayoutManager(this, 3));
        try {
            InitVariable();
            bindingListProduct();
            setEvenListener ();
        } catch (Exception e) {
            Toast.makeText(CategoryDetailActivity.this, "ERROR: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void setEvenListener() {
        btn_back.setOnClickListener(event -> {
            finish();
        });
    }


    public void bindingListProduct (){
        try {

            ProductService.getInstance(getString(R.string.BASE_URL)).GetListProductCategory ( categoryInfo.getCategoryID() , new  Callback<List<ProductInfo>>(){

            @Override
            public void onResponse(Call<List<ProductInfo>> call, Response<List<ProductInfo>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(CategoryDetailActivity.this , response.message(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<ProductInfo> ListProduct = response.body();
                if (ListProduct != null ){
                    CategoryDetailAdapter categoryDetailAdapter = new CategoryDetailAdapter(CategoryDetailActivity.this, ListProduct);
                    binding.listCartInfo.setAdapter(categoryDetailAdapter);
                }
            }
            @Override
            public void onFailure(Call<List<ProductInfo>> call, Throwable t) {
                Toast.makeText(CategoryDetailActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        } catch (Exception e) {
            Toast.makeText(CategoryDetailActivity.this, "ERROR: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    private void InitVariable (){
        customerInfo = (CustomerInfo) getIntent().getSerializableExtra("customerInfo");
        btn_back = findViewById(R.id.btn_back);

    }

    public void handlerViewCategoryProductDetail(ProductInfo item) {
        Intent intent = new Intent(getApplicationContext(), DesignListProductDetailBinding.class);
        startActivity(intent);
    }
    public void InsertToCart (ProductInfo item) {

        CartInfo cartInfo = new CartInfo();
        cartInfo.setCustomerID(customerInfo.getCustomerID());
        cartInfo.setProductID(item.getProductID());
        CartService.getInstance(getString(R.string.BASE_URL)).insertCart(cartInfo, new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(CategoryDetailActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Boolean result = response.body();
                if (result == true ){
                    Toast.makeText(CategoryDetailActivity.this, "Thêm vào giỏ hàng thành công " , Toast.LENGTH_SHORT ).show();
                }

            }


            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Toast.makeText(CategoryDetailActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
