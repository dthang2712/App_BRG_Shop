package com.example.brg_shopping.BusinessView.Activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brg_shopping.R;

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
    }

    private void search(String query) {
        // cmm
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
