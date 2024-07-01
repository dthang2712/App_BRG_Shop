package com.example.brg_shopping.BusinessView.Activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.brg_shopping.BusinessObject.CartInfo;
import com.example.brg_shopping.BusinessObject.CustomerInfo;
import com.example.brg_shopping.BusinessObject.ProductInfo;
import com.example.brg_shopping.BusinessService.CartService.CartService;
import com.example.brg_shopping.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductActivity extends AppCompatActivity {
    ProductInfo productInfo;
    CustomerInfo customerInfo;

    Button btn_back;
    TextView txtName;
    TextView txtProductDescription;
    TextView txtPrice;
    TextView txtPlus;
    TextView txtMinus;
    TextView txtAmount;
    TextView txtAddToCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product);
        try {
            InitVariable ();
            setEvenListener();
            setProductInfo();
        } catch (Exception ex) {
            Log.e("ERROR", "ProductActivity|" + ex.getMessage());
            Toast.makeText(getApplicationContext(), "ERROR: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void setProductInfo() {
        txtName.setText(productInfo.getProductName());
        txtProductDescription.setText(productInfo.getContent());
        txtPrice.setText(String.valueOf(productInfo.getPrice()));
    }

    private void InitVariable() {
        productInfo = (ProductInfo) getIntent().getSerializableExtra("ProductInfo");
        customerInfo = (CustomerInfo) getIntent().getSerializableExtra("customerInfo");

        btn_back = findViewById(R.id.btn_back);
        txtName = findViewById(R.id.TextView_Name);
        txtProductDescription = findViewById(R.id.txt_product_description);
        txtPrice= findViewById(R.id.TextView_price);
        txtPlus = findViewById(R.id.txt_plus);
        txtMinus = findViewById(R.id.txt_minus);
        txtAmount = findViewById(R.id.amount);
        txtAddToCart = findViewById(R.id.txt_add_to_cart);
    }

    private void setEvenListener() {
        btn_back.setOnClickListener(event -> {
            finish();
        });

        txtPlus.setOnClickListener(event -> {
            Integer amount = Integer.valueOf(txtAmount.getText().toString());
            amount+= 1;
            txtAmount.setText(String.valueOf(amount));
            if (amount > 1) {
                txtMinus.setEnabled(true);
            }
        });

        txtMinus.setOnClickListener(event -> {
            Integer amount = Integer.valueOf(txtAmount.getText().toString());
            amount-= 1;
            if (amount <= 1) {
                txtMinus.setEnabled(false);
            }
            txtAmount.setText(String.valueOf(amount));
        });

        txtAddToCart.setOnClickListener(event -> {
            Integer amount = Integer.valueOf(txtAmount.getText().toString());
            productInfo.setAmount(amount);
            InsertToCart(productInfo);
        });
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
}