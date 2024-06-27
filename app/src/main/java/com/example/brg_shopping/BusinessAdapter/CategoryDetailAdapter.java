package com.example.brg_shopping.BusinessAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brg_shopping.BusinessObject.ProductInfo;
import com.example.brg_shopping.BusinessView.Activity.CategoryDetailActivity;
import com.example.brg_shopping.R;
import com.example.brg_shopping.databinding.DesignProductBinding;

import java.util.List;

public class CategoryDetailAdapter extends RecyclerView.Adapter<CategoryDetailAdapter.CategoryViewHolder> {

    private final CategoryDetailActivity categoryDetailActivity ;
    private final List<ProductInfo> collection ;

    public CategoryDetailAdapter (CategoryDetailActivity categoryDetailActivity, List<ProductInfo> collection ){
        this.categoryDetailActivity = categoryDetailActivity;
        this.collection = collection;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.design_product, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        ProductInfo item = collection.get(position);
        if (item != null){
            holder.binding.TextViewProduct.setText(item.getProductName());
            holder.binding.TextViewPrice.setText(item.getPrice().toString());

            holder.binding.imageProduct.setOnClickListener(event -> {
                categoryDetailActivity.handlerViewCategoryProductDetail(item);
            });
            holder.binding.TextViewAddtocard.setOnClickListener(event -> {
                categoryDetailActivity.InsertToCart(item);
            });
        }
    }

    @Override
    public int getItemCount() {return collection.size();}

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        private DesignProductBinding binding;
        public CategoryViewHolder (@NonNull View itemView) {
            super(itemView);
            binding = DesignProductBinding.bind(itemView);
        }

    }
}
