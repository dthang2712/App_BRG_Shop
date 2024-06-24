package com.example.brg_shopping.BusinessView.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.brg_shopping.BusinessView.Fragment.AccountInfoFragment;
import com.example.brg_shopping.BusinessView.Fragment.CartConfirmFragment;
import com.example.brg_shopping.BusinessView.Fragment.HomeFragment;
import com.example.brg_shopping.BusinessView.Fragment.ProfileFragment;
import com.example.brg_shopping.BusinessView.Fragment.SearchFragment;
import com.example.brg_shopping.CartListProductFragment;
import com.example.brg_shopping.R;
import com.example.brg_shopping.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.bottomView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();

                if (id == R.id.navigation_home) {
                    replaceFragment(new HomeFragment());
                    return true;
                }

                if (id == R.id.navigation_search) {
                    replaceFragment(new SearchFragment());
                    return true;
                }
                if (id == R.id.navigation_cart) {
                    replaceFragment(new CartListProductFragment());
                    return true;
                }
                if (id == R.id.navigation_aboutme) {
                    replaceFragment(new AccountInfoFragment());
                    return true;
                }


                //               case R.id.navigation_search:
//                   replaceFragment(new SearchFragment());
//                   break;
//               case R.id.navigation_cart:
//                   replaceFragment(new CartConfirmFragment());
//                   break;
//               case R.id.navigation_aboutme:
//                   replaceFragment(new ProfileFragment());
//                   break;


                return false;
            }
        });


        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        HomeFragment homeFragment = new HomeFragment ();
        transaction.add(R.id.Layout_frame_main,homeFragment);
        transaction.addToBackStack(null);
        transaction.commit();




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    private void replaceFragment (Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.Layout_frame_main, fragment);
        fragmentTransaction.commit();
    }
}