package com.example.brg_shopping.BusinessAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brg_shopping.BusinessObject.CartInfo;
import com.example.brg_shopping.CartListProductFragment;
import com.example.brg_shopping.R;
import com.example.brg_shopping.databinding.DesignListCardBinding;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private final CartListProductFragment cartListProductFragment;
    private final List<CartInfo> collection ;
    public CartAdapter (CartListProductFragment cartListProductFragment, List<CartInfo> collection ){
        this.cartListProductFragment = cartListProductFragment;
        this.collection = collection;
    }
    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.design_list_card , parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartInfo item = collection.get(position);
        if (item != null){
            holder.binding.TextViewProduct.setText(item.getProductName());

            holder.binding.amount.setText(String.valueOf(item.getAmount()));

            holder.binding.plus.setOnClickListener(event -> {
                item.setAmount(item.getAmount() + 1);
                holder.binding.amount.setText(String.valueOf(item.getAmount()));

                // Call Api cộng
            });

            holder.binding.minus.setOnClickListener(event -> {
                if (item.getAmount() > 0) {
                    item.setAmount(item.getAmount() - 1);
                    holder.binding.amount.setText(String.valueOf(item.getAmount()));

                    // Call Api trừ
                }
            });

            holder.binding.TextViewProduct.setOnClickListener(event -> {
                cartListProductFragment.handlerViewCategoryDetail(item);
            });
        }
    }

    @Override
    public int getItemCount() { return collection.size(); }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        private DesignListCardBinding binding ;
        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DesignListCardBinding.bind(itemView);
        }
    }
}
