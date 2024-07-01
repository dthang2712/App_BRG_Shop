package com.example.brg_shopping.BusinessView.Activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brg_shopping.BusinessAdapter.SearchCategoryAdapter;
import com.example.brg_shopping.BusinessAdapter.SearchProductionAdapter;
import com.example.brg_shopping.BusinessObject.CategoryInfo;
import com.example.brg_shopping.BusinessObject.ProductInfo;
import com.example.brg_shopping.R;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

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
        List<CategoryInfo> categoryInfoList = new ArrayList<>();
        for(int l=0; l<=5; l++){
            CategoryInfo categoryInfo = new CategoryInfo();
            categoryInfo.setCategoryID(l + 1);
            categoryInfo.setCategoryName("Category");
            categoryInfoList.add(categoryInfo);
        }
        SearchCategoryAdapter searchCategoryAdapter = new SearchCategoryAdapter(this, categoryInfoList);
        listCategoryResult.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        listCategoryResult.setAdapter(searchCategoryAdapter);

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
//        listProductionResult.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        listProductionResult.setAdapter(searchProductionAdapter);
    }

    private void setEvenListener() {
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
        imgBack = findViewById(R.id.img_back);
        searchView = findViewById(R.id.search_view);
        listCategoryResult = findViewById(R.id.list_category_result);
        listProductionResult = findViewById(R.id.list_production_result);
    }
}
