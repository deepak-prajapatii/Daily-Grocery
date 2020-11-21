package com.riseinsteps.dailygrocery.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.riseinsteps.dailygrocery.R;
import com.riseinsteps.dailygrocery.model.AllCategoryModel;

import java.util.List;

public class AllCategoryAdaptor extends RecyclerView.Adapter<AllCategoryAdaptor.AllCategoryViewHolder> {
    private Context context;
    private List<AllCategoryModel> allCategoryModelList;

    public AllCategoryAdaptor(Context context, List<AllCategoryModel> allCategoryModelList) {
        this.context = context;
        this.allCategoryModelList = allCategoryModelList;
    }

    @NonNull
    @Override
    public AllCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.all_category_row,parent,false);
        return new AllCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllCategoryViewHolder holder, int position) {
        AllCategoryModel allCategoryModel = allCategoryModelList.get(position);
        holder.allCategoryItemImage.setImageResource(allCategoryModel.getImage());
    }

    @Override
    public int getItemCount() {
        return allCategoryModelList.size();
    }

    public class AllCategoryViewHolder extends RecyclerView.ViewHolder {
        private ImageView allCategoryItemImage;

        public AllCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            allCategoryItemImage = itemView.findViewById(R.id.allcategory_item_image);
        }
    }
}
