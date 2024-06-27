package com.example.brg_shopping.BusinessView.Activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

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
        try {
            InitVariable ();
            setEvenListener();
        } catch (Exception ex) {
            Log.e("ERROR", "ProductActivity|" + ex.getMessage());
            Toast.makeText(getApplicationContext(), "ERROR: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
//        btn_back.setOnClickListener(event -> {
//            finish();
//        });
    }

    private void InitVariable() {
        btn_back = findViewById(R.id.btn_back);
    }

    private void setEvenListener() {
        btn_back.setOnClickListener(event -> {
            finish();
        });
    }
}