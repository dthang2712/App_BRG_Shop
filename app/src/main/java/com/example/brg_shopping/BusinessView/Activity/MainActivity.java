package com.example.brg_shopping.BusinessView.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.brg_shopping.BusinessObject.CustomerInfo;
import com.example.brg_shopping.BusinessView.Fragment.AccountInfoFragment;
import com.example.brg_shopping.BusinessView.Fragment.CartConfirmFragment;
import com.example.brg_shopping.BusinessView.Fragment.HomeFragment;
import com.example.brg_shopping.BusinessView.Fragment.ProfileFragment;
import com.example.brg_shopping.BusinessView.Fragment.SearchFragment;
import com.example.brg_shopping.CartListProductFragment;
import com.example.brg_shopping.R;
import com.example.brg_shopping.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    CustomerInfo customerInfo;
    HomeFragment homeFragment = new HomeFragment();

    SearchFragment searchFragment = new SearchFragment();
    CartListProductFragment cartListProductFragment = new CartListProductFragment();
    AccountInfoFragment accountInfoFragment = new AccountInfoFragment();
    BottomNavigationView bottom_view ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            InitVariable();
            setEventListener();
        } catch (Exception ex) {
            Log.e("ERROR", "MainActivity|" + ex.getMessage());
            Toast.makeText(MainActivity.this, "ERROR: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    private void setEventListener() {
        bottom_view.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();


                if (id == R.id.navigation_home) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("customerInfo" , customerInfo );
                    getSupportFragmentManager().executePendingTransactions();
                    getSupportFragmentManager().beginTransaction().replace(R.id.Layout_frame_main, homeFragment ).commit();
                    homeFragment.setArguments(bundle);
                    return true;
                }

//                if (id == R.id.navigation_search) {
//                    getSupportFragmentManager().beginTransaction().replace(R.id.Layout_frame_main, searchFragment ).commit();
//                    return true;
//                }
                if (id == R.id.navigation_cart) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("customerInfo" , customerInfo );
                    getSupportFragmentManager().executePendingTransactions();
                    getSupportFragmentManager().beginTransaction().replace(R.id.Layout_frame_main, cartListProductFragment ).commit();
                    cartListProductFragment.setArguments(bundle);
                    return true;
                }
                if (id == R.id.navigation_aboutme) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.Layout_frame_main, accountInfoFragment ).commit();
                    return true;
                }

                return false;
            }
        });


    }

    private void InitVariable() {
        customerInfo = (CustomerInfo) getIntent().getSerializableExtra("customerInfo");

        getSupportFragmentManager().executePendingTransactions();
        getSupportFragmentManager().beginTransaction().replace(R.id.Layout_frame_main, homeFragment ).commit();

        Bundle bundle = new Bundle();
        bundle.putSerializable("customerInfo" , customerInfo );
        homeFragment.setArguments(bundle);

        bottom_view = findViewById(R.id.bottom_view) ;

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}