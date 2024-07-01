package com.example.brg_shopping.BusinessView.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.brg_shopping.BusinessAdapter.CategoryAdapter;
import com.example.brg_shopping.BusinessAdapter.ProductAdapter;
import com.example.brg_shopping.BusinessObject.CartInfo;
import com.example.brg_shopping.BusinessObject.CategoryInfo;
import com.example.brg_shopping.BusinessObject.CustomerInfo;
import com.example.brg_shopping.BusinessObject.ProductInfo;
import com.example.brg_shopping.BusinessService.CartService.CartService;
import com.example.brg_shopping.BusinessService.CategoryService.CategoryService;
import com.example.brg_shopping.BusinessService.ProductService.ProductService;
import com.example.brg_shopping.BusinessView.Activity.CartVerifyActivity;
import com.example.brg_shopping.BusinessView.Activity.CategoryDetailActivity;
import com.example.brg_shopping.BusinessView.Activity.ProductActivity;
import com.example.brg_shopping.BusinessView.Activity.SearchActivity;
import com.example.brg_shopping.R;
import com.example.brg_shopping.databinding.DesignListProductDetailBinding;
import com.example.brg_shopping.databinding.FragmentCardListProductBinding;
import com.example.brg_shopping.databinding.FragmentHomeBinding;
import com.google.android.material.navigation.NavigationBarView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    RecyclerView recyclerView ;
    CustomerInfo customerInfo;
    RelativeLayout searchView ;
    ProductInfo productInfo ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        try {
            InitVariable(view);
            setEventListener();
            bindingListCategory(view);
            bindingListProduct(view);
        } catch (Exception e) {
            Toast.makeText(view.getContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        return view;
    }

    private void bindingListProduct(View view) {
        ProductService.getInstance(getString(R.string.BASE_URL)).GetAllProduct(new Callback<List<ProductInfo>>(){

            @Override
            public void onResponse(Call<List<ProductInfo>> call, Response<List<ProductInfo>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(view.getContext(), response.message(), Toast.LENGTH_SHORT).show();
                    return;
                }
                recyclerView = FragmentHomeBinding.bind(view).rvListProductHome;
                recyclerView .setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL,false));
                List<ProductInfo> ListProduct = response.body();
                if (ListProduct.size() > 0 ){
                    ProductAdapter productAdapter = new ProductAdapter(HomeFragment.this, ListProduct);
                    recyclerView.setAdapter(productAdapter);

                }

            }

            @Override
            public void onFailure(Call<List<ProductInfo>> call, Throwable t) {
                Toast.makeText(view.getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;
    }

    public void bindingListCategory (View view){
        CategoryService.getInstance(getString(R.string.BASE_URL)).GetAllCategory(new Callback<List<CategoryInfo>>() {

            @Override
            public void onResponse(Call<List<CategoryInfo>> call, Response<List<CategoryInfo>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(view.getContext(), response.message(), Toast.LENGTH_SHORT).show();
                    return;
                }
                recyclerView = FragmentHomeBinding.bind(view).rvListcategoryHome;
                recyclerView .setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL,false));
                List<CategoryInfo> ListCategory = response.body();
                if (ListCategory.size() > 0 ){
                    CategoryAdapter categoryAdapter = new CategoryAdapter(HomeFragment.this, ListCategory);
                    recyclerView.setAdapter(categoryAdapter);

                }

            }
            @Override
            public void onFailure(Call<List<CategoryInfo>> call, Throwable t) {
                Toast.makeText(view.getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void InitVariable(View view) {
        customerInfo = (CustomerInfo) getArguments().getSerializable("customerInfo");
        searchView = view.findViewById(R.id.search_view);
    }

    private void setEventListener() {
        searchView.setOnClickListener(event ->{
            Intent intent = new Intent(this.getContext(), SearchActivity.class);
            intent.putExtra("customerInfo" , customerInfo);
            startActivity(intent);
        });
    }

    public void handlerViewCategoryDetail(CategoryInfo item) {
        Intent intent = new Intent(this.getContext(), CategoryDetailActivity.class);
        intent.putExtra("customerInfo" , customerInfo);
        intent.putExtra("categoryInfo" , item);
        startActivity(intent);
    }

    public void handlerViewProductDetail(ProductInfo item) {
        Intent intent = new Intent(this.getContext(), ProductActivity.class);
        startActivity(intent);
    }

    public void InsertToCart(ProductInfo item) {

        CartInfo cartInfo = new CartInfo();
        cartInfo.setCustomerID(customerInfo.getCustomerID());
        cartInfo.setProductID(item.getProductID());
        CartService.getInstance(getString(R.string.BASE_URL)).insertCart(cartInfo, new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(mContext, response.message(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Boolean result = response.body();
                if (result == true ){
                    Toast.makeText(mContext, "Thêm vào giỏ hàng thành công " , Toast.LENGTH_SHORT ).show();
                }

            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Toast.makeText(mContext, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}