package com.example.brg_shopping.BusinessAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brg_shopping.BusinessObject.ProductInfo;
import com.example.brg_shopping.BusinessView.Activity.CategoryDetailActivity;
import com.example.brg_shopping.BusinessView.Fragment.HomeFragment;
import com.example.brg_shopping.R;
import com.example.brg_shopping.databinding.DesignListCategoryBinding;
import com.example.brg_shopping.databinding.DesignProductBinding;

import java.util.List;
    public class ProductAdapter extends RecyclerView.Adapter<com.example.brg_shopping.BusinessAdapter.ProductAdapter.ProductViewHolder> {
        private final HomeFragment homeFragment;

        private final List<ProductInfo> collection;

        public ProductAdapter(HomeFragment homeFragment, List<ProductInfo> collection) {
            this.homeFragment = homeFragment;
            this.collection = collection;
        }

        @NonNull
        @Override
        public com.example.brg_shopping.BusinessAdapter.ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.design_product, parent, false);
            return new com.example.brg_shopping.BusinessAdapter.ProductAdapter.ProductViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull com.example.brg_shopping.BusinessAdapter.ProductAdapter.ProductViewHolder holder, int position) {
            ProductInfo item = collection.get(position);
            if (item != null) {
                holder.binding.TextViewProduct.setText(item.getProductName());
                holder.binding.TextViewPrice.setText(item.getPrice().toString());

                holder.binding.imageProduct.setOnClickListener(event -> {
                    homeFragment.handlerViewProductDetail( item );
                });
                holder.binding.TextViewProduct.setOnClickListener(event -> {
                    homeFragment.handlerViewProductDetail( item );
                });
                holder.binding.TextViewPrice.setOnClickListener(event -> {
                    homeFragment.handlerViewProductDetail( item );
                });
                holder.binding.TextViewPriceDisscound.setOnClickListener(event -> {
                    homeFragment.handlerViewProductDetail( item );
                });
                holder.binding.TextViewAddtocard.setOnClickListener(event ->{
                    homeFragment.InsertToCart(item);
                });


            }
        }

        @Override
        public int getItemCount() {
            return collection.size();
        }

        public static class ProductViewHolder extends RecyclerView.ViewHolder {
            private DesignProductBinding binding;

            public ProductViewHolder(@NonNull View itemView) {
                super(itemView);
                binding = DesignProductBinding.bind(itemView);
            }
        }
    }
