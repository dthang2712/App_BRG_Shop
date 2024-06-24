package com.example.brg_shopping.BusinessView.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.brg_shopping.BusinessObject.CustomerInfo;
import com.example.brg_shopping.BusinessService.CustomerService.CustomerService;
import com.example.brg_shopping.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText edt_sdt;
    EditText edt_mk;
    TextView TextView_login;

    TextView register ;
    CustomerInfo customerInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        try {
            InitVariable();
            setEvenListener();
        } catch (Exception ex) {
            Log.e("ERROR", "LoginActivity|" + ex.getMessage());
            Toast.makeText(getApplicationContext(), "ERROR: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void setEvenListener() {
        TextView_login.setOnClickListener(event -> {
            if (ValidateInput()) {
                try {
                    CustomerService.getInstance(getString(R.string.BASE_URL)).getCustomerByPhoneNumber(edt_sdt.getText().toString(), new Callback<CustomerInfo>() {
                        @Override
                        public void onResponse(Call<CustomerInfo> call, Response<CustomerInfo> response) {

                            if (!response.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_SHORT).show();
                                return;
                            }

                            customerInfo = response.body();

                            if (customerInfo.getPhoneNumber() == null) {
                                Log.d("DEBUG", "LoginActivity|Tài khoản không tồn tại");
                                Toast.makeText(getApplicationContext(), "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show();
                                return;
                            }

                            if (customerInfo.getPassword().equals(edt_mk.getText().toString())) {
                                edt_mk.setError("Login thành công");
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                                finish();



                                Log.d("DEBUG", "LoginActivity|Login thành công");

                            } else {
                                edt_mk.setError("Mật khẩu không đúng");
                                Log.d("DEBUG", "LoginActivity|Mật khẩu không đúng");
                            }
                        }

                        @Override
                        public void onFailure(Call<CustomerInfo> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        register.setOnClickListener(event ->{
            Intent intent = new Intent(getApplicationContext(), CartVerifyActivity.class);
            startActivity(intent);
        });

    }

    private boolean ValidateInput() {
        if (edt_sdt.getText().toString().isEmpty()) {
            edt_sdt.setError("Vui lòng nhập số điện thoại!");
            edt_sdt.requestFocus();
            return false;
        }
        if (edt_mk.getText().toString().isEmpty()) {
            edt_mk.setError("Vui lòng nhập mật khẩu!");
            edt_mk.requestFocus();
            return false;
        }
        return true;
    }


    private void InitVariable() {
        TextView_login = findViewById(R.id.TextView_login);
        edt_sdt = findViewById(R.id.edt_sdt);
        edt_mk = findViewById(R.id.edt_mk);
        register = findViewById(R.id.register);
        customerInfo = (CustomerInfo) getIntent().getSerializableExtra("customerInfo");

    }
}