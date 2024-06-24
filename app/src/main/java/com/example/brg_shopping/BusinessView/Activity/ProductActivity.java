package com.example.brg_shopping.BusinessView.Activity;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.brg_shopping.R;

public class ProductActivity extends AppCompatActivity {
    Button btn_back ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product);
//        btn_back.setOnClickListener(event -> {
//            finish();
//        });
    }
}