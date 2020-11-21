package com.riseinsteps.dailygrocery.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.riseinsteps.dailygrocery.R;
import com.riseinsteps.dailygrocery.model.CategoryModel;

import java.util.List;

public class CategoryAdaptor extends RecyclerView.Adapter<CategoryAdaptor.CategoryViewHolder> {

    private Context context;
    private List<CategoryModel> categoryModelList;

    public CategoryAdaptor(Context context, List<CategoryModel> categoryModelList) {
        this.context = context;
        this.categoryModelList = categoryModelList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_row, parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        CategoryModel categoryModel = categoryModelList.get(position);
        holder.categoryItemImage.setImageResource(categoryModel.getImage());
    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        private ImageView categoryItemImage;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryItemImage = itemView.findViewById(R.id.category_item_image);
        }
    }
}
