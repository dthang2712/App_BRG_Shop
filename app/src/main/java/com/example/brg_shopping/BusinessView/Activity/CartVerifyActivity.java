package com.example.brg_shopping.BusinessView.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.brg_shopping.BusinessObject.CustomerInfo;
import com.example.brg_shopping.BusinessService.CustomerService.CustomerService;
import com.example.brg_shopping.R;
import com.example.brg_shopping.databinding.ActivityCartVerifyBinding;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartVerifyActivity extends AppCompatActivity {
    private int mYear, mMonth, mDay, mHour, mMinute;
    ActivityCartVerifyBinding binding;
    EditText edt_sdt;
    EditText edt_gmail;
    EditText edt_password;
    EditText edt_fullname;
    TextView TextView_birthday;
    RadioButton Radio_sexnam;
    RadioButton Radio_sexnu;

    TextView textView_Verify;
    CheckBox checkbox_rules;
    Button btn_back;
    CustomerInfo customerInfo;
    TextView errorText;
    TextView register ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart_verify);
        try {
            InitVariable();
            setEvenListener();
        } catch (Exception ex) {
            Log.e("ERROR", "CartVerifyActivity|" + ex.getMessage());
            Toast.makeText(getApplicationContext(), "ERROR: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
//        binding.btnBack.setOnClickListener(v -> {
//            finish();
//        });
    }


    private void setEvenListener() {
        textView_Verify.setOnClickListener(event -> {
            if (ValidateInput()) {
                CustomerInfo infoInsert = new CustomerInfo();
                infoInsert.setPhoneNumber(edt_sdt.getText().toString());
                infoInsert.setEmail(edt_gmail.getText().toString());
                infoInsert.setDateOfBirth(TextView_birthday.getText().toString());
                infoInsert.setFullName(edt_fullname.getText().toString());
                infoInsert.setPassword(edt_password.getText().toString());
                infoInsert.setSex(Radio_sexnam.getText().toString());
                infoInsert.setSex(Radio_sexnu.getText().toString());



                try {
                    CustomerService.getInstance(getString(R.string.BASE_URL)).CheckInsertPhoneNumber(edt_sdt.getText().toString(), new Callback<Boolean>() {
                        @Override
                        public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                            if (!response.isSuccessful()){
                                Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_SHORT).show();
                                return;
                            }
                            Boolean result = response.body();

                            if (result == true){
                                edt_sdt.setError("Số điện thoại đã tồn tại!");
                                edt_sdt.requestFocus();
                            }
                            else {
                                CustomerService.getInstance(getString(R.string.BASE_URL)).insertCustomer(infoInsert, new Callback<Boolean>() {
                                    @Override
                                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                                        if (!response.isSuccessful()) {
                                            Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_SHORT).show();
                                            return;
                                        }
                                        Boolean result = response.body();

                                    }
                                    @Override
                                    public void onFailure(Call<Boolean> call, Throwable t) {
                                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                                register.setOnClickListener(event ->{
                                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                    startActivity(intent);

                                });
                            }
                        }


                        @Override
                        public void onFailure(Call<Boolean> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });

        TextView_birthday.setOnClickListener(event -> {
            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    TextView_birthday.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                }
            }, mYear, mMonth, mDay);
            datePickerDialog.show();
        });
        btn_back.setOnClickListener(event -> {
            finish();
        });
        checkbox_rules.setOnClickListener(event -> {
            if (checkbox_rules.isChecked()) {
                errorText.setText(null);
            }
        });
    }

    private boolean ValidateInput() {
        if (edt_sdt.getText().toString().isEmpty()) {
            edt_sdt.setError("Vui lòng nhập số điện thoại! ");
            edt_sdt.requestFocus();
            return false;
        }
        if (edt_gmail.getText().toString().isEmpty()) {
            edt_gmail.setError("Vui lòng nhập Gmail! ");
            edt_gmail.requestFocus();
            return false;
        }
        if (TextView_birthday.getText().toString().isEmpty()) {
            TextView_birthday.setError("Vui lòng nhập ngày sinh ");
            TextView_birthday.requestFocus();
            return false;
        }
        if (!checkbox_rules.isChecked()) {
            errorText.setText("Vui lòng tích chọn đồng ý với điều khoản");
            return false;
        }
        if (!Radio_sexnam.isChecked() && !Radio_sexnu.isChecked()) {
            errorText.setText("Vui lòng chọn giới tính");
            return false;
        }
        if (edt_fullname.getText().toString().isEmpty()) {
            edt_fullname.setError("Vui lòng nhập họ tên đầy đủ");
            edt_fullname.requestFocus();
            return false;
        }
        if (edt_password.getText().toString().isEmpty()) {
            edt_password.setError("Vui lòng nhập mật khẩu");
            edt_password.requestFocus();
            return false;
        }
        if (TextView_birthday.getText().toString().isEmpty()) {
            TextView_birthday.setError("Vui lòng nhập ngày sinh ");
            TextView_birthday.requestFocus();
            return false;
        }

        return true;
    }

    private void InitVariable() {
        textView_Verify = findViewById(R.id.register);
        edt_sdt = findViewById(R.id.edt_sdt);
        edt_gmail = findViewById(R.id.edt_gmail);
        TextView_birthday = findViewById(R.id.TextView_birthday);
        btn_back = findViewById(R.id.btn_back);
        checkbox_rules = findViewById(R.id.checkbox_rules);
        errorText = findViewById(R.id.errorText);
        edt_fullname = findViewById(R.id.edt_fullname);
        edt_password = findViewById(R.id.edt_password);
        Radio_sexnam = findViewById(R.id.Radio_sexnam);
        Radio_sexnu = findViewById(R.id.Radio_sexnu);
    }
}