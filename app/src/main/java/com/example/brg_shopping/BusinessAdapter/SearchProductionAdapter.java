package com.example.brg_shopping.BusinessAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brg_shopping.BusinessObject.CategoryInfo;
import com.example.brg_shopping.BusinessObject.ProductInfo;
import com.example.brg_shopping.BusinessView.Activity.SearchActivity;
import com.example.brg_shopping.R;
import com.example.brg_shopping.databinding.DesignListCardBinding;
import com.example.brg_shopping.databinding.DesignListProductDetailBinding;
import com.example.brg_shopping.databinding.DesignProductBinding;

import java.util.List;

public class SearchProductionAdapter extends RecyclerView.Adapter<SearchProductionAdapter.SearchCategoryHolder> {
    private final SearchActivity context;
    private final List<ProductInfo> collection ;
    public SearchProductionAdapter (SearchActivity context, List<ProductInfo> collection ){
        this.context = context;
        this.collection = collection;
    }
    @NonNull
    @Override
    public SearchCategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.design_product , parent, false);
        return new SearchCategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchCategoryHolder holder, int position) {
        ProductInfo item = collection.get(position);
        if (item != null){
            holder.binding.TextViewProduct.setText(item.getProductName());
            holder.binding.TextViewPrice.setText(String.valueOf(item.getPrice()));
            holder.binding.TextViewAddtocard.setOnClickListener(event -> {
                context.InsertToCart(item);
            });
            holder.binding.imageProduct.setOnClickListener(event -> {
                context.handlerViewProductDetail(item);
            });
        }
    }

    @Override
    public int getItemCount() { return collection.size(); }

    public static class SearchCategoryHolder extends RecyclerView.ViewHolder {
        private DesignProductBinding binding ;
        public SearchCategoryHolder(@NonNull View itemView) {
            super(itemView);
            binding = DesignProductBinding.bind(itemView);
        }
    }
}
