package com.example.brg_shopping.BusinessAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brg_shopping.BusinessObject.CategoryInfo;
import com.example.brg_shopping.BusinessView.Fragment.HomeFragment;
import com.example.brg_shopping.R;
import com.example.brg_shopping.databinding.DesignListCategoryBinding;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private final HomeFragment homeFragment;
    private final List<CategoryInfo> collection ;
    public CategoryAdapter (HomeFragment homeFragment, List<CategoryInfo> collection ){
        this.homeFragment = homeFragment;
        this.collection = collection;
    }
    @NonNull
    @Override
    public CategoryAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.design_list_category , parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryViewHolder holder, int position) {
        CategoryInfo item = collection.get(position);
        if (item != null){
            holder.binding.TextViewName.setText(item.getCategoryName());

            holder.binding.ImgCategory.setOnClickListener(event -> {
                homeFragment.handlerViewCategoryDetail(item);
            });
            holder.binding.TextViewName.setOnClickListener(event -> {
                homeFragment.handlerViewCategoryDetail(item);
            });



        }
    }

    @Override
    public int getItemCount() {return collection.size();}
    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        private DesignListCategoryBinding binding ;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DesignListCategoryBinding.bind(itemView);
        }
    }
}
