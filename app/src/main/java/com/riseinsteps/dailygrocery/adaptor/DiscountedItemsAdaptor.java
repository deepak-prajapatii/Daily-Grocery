package com.riseinsteps.dailygrocery.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.riseinsteps.dailygrocery.R;
import com.riseinsteps.dailygrocery.model.DiscountedItemsModel;

import java.util.List;

public class DiscountedItemsAdaptor extends RecyclerView.Adapter<DiscountedItemsAdaptor.DiscountedViewHolder> {

    Context context;
    List<DiscountedItemsModel> discountedItemsModelList;

    public DiscountedItemsAdaptor(Context context, List<DiscountedItemsModel> discountedItemsModelList) {
        this.context = context;
        this.discountedItemsModelList = discountedItemsModelList;
    }

    @NonNull
    @Override
    public DiscountedItemsAdaptor.DiscountedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.discounted_item_row, parent, false);
        return new DiscountedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscountedItemsAdaptor.DiscountedViewHolder holder, int position) {
        DiscountedItemsModel discountedItemsModel = discountedItemsModelList.get(position);
        holder.discountedItemImage.setImageResource(discountedItemsModel.getImage());
    }

    @Override
    public int getItemCount() {
        return discountedItemsModelList.size();
    }

    public static class DiscountedViewHolder extends RecyclerView.ViewHolder {
        private ImageView discountedItemImage;
        public DiscountedViewHolder(@NonNull View itemView) {
            super(itemView);
            discountedItemImage = itemView.findViewById(R.id.discounted_item_image);
        }
    }
}
