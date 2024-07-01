package com.example.brg_shopping.BusinessView.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.brg_shopping.BusinessAdapter.CartAdapter;
import com.example.brg_shopping.BusinessObject.CartInfo;
import com.example.brg_shopping.BusinessObject.CustomerInfo;
import com.example.brg_shopping.BusinessService.CartService.CartService;
import com.example.brg_shopping.BusinessView.Activity.CategoryDetailActivity;
import com.example.brg_shopping.R;
import com.example.brg_shopping.databinding.FragmentCardListProductBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CartListProductFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartListProductFragment extends Fragment {
    RecyclerView recyclerView ;
    CustomerInfo customerInfo;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    public static CartListProductFragment newInstance(String param1, String param2) {
        CartListProductFragment fragment = new CartListProductFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_card_list_product, container, false);
        InitVariable(view);
        bindingListCart(view);
        return view;
    }

    public void bindingListCart (View view) {
        try {
            CartService.getInstance(getString(R.string.BASE_URL)).GetCartCustomer(customerInfo.getCustomerID(), new Callback<List<CartInfo>>() {

                @Override
                public void onResponse(Call<List<CartInfo>> call, Response<List<CartInfo>> response) {
                    if (!response.isSuccessful()) {
                        Toast.makeText(view.getContext(), response.message(), Toast.LENGTH_SHORT).show();
                        return;
                    }
                    recyclerView = FragmentCardListProductBinding.bind(view).rvListCart;
                    recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));
                    List<CartInfo> listCart = response.body();

                    if (listCart.size() > 0) {
                        CartAdapter categoryAdapter = new CartAdapter(CartListProductFragment.this, listCart);
                        recyclerView.setAdapter(categoryAdapter);

                    }

                }

                @Override
                public void onFailure(Call<List<CartInfo>> call, Throwable t) {
                    Toast.makeText(view.getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }catch (Exception e) {
            Toast.makeText(view.getContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void handlerViewCategoryDetail(CartInfo item) {
        Intent intent = new Intent(this.getContext(), CategoryDetailActivity.class);
        intent.putExtra("categoryInfo" , item);
        startActivity(intent);
    }

    private void InitVariable(View view) {
        customerInfo = (CustomerInfo) getArguments().getSerializable("customerInfo");
    }
}