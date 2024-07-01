package com.example.brg_shopping.BusinessAdapter;

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
    private final SearchActivity searchActivity;
    private final List<ProductInfo> collection ;
    public SearchProductionAdapter (SearchActivity searchActivity, List<ProductInfo> collection ){
        this.searchActivity = searchActivity;
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
//            holder.binding.TextViewProduct.setOnClickListener(event -> {
//                searchActivity.handlerViewCategoryDetail(item);
//            });
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
