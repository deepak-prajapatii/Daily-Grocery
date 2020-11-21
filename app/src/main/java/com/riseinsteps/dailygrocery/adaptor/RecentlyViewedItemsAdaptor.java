package com.riseinsteps.dailygrocery.adaptor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.riseinsteps.dailygrocery.MainActivity;
import com.riseinsteps.dailygrocery.ProductDetailsActivity;
import com.riseinsteps.dailygrocery.R;
import com.riseinsteps.dailygrocery.model.RecentlyViewedItemModel;

import java.util.List;

public class RecentlyViewedItemsAdaptor extends RecyclerView.Adapter<RecentlyViewedItemsAdaptor.RecentlyViewedItemHolder> {

    public static final String PRODUCT_IMAGE = "com.riseinsteps.dailygrocery.PRODUCT_IMAGE";
    public static final String PRODUCT_ID = "com.riseinsteps.dailygrocery.PRODUCT_ID";
    public static final String PRODUCT_NAME = "com.riseinsteps.dailygrocery.PRODUCT_NAME";
    public static final String PRODUCT_DESC = "com.riseinsteps.dailygrocery.PRODUCT_DESC";
    public static final String PRODUCT_PRICE = "com.riseinsteps.dailygrocery.PRODUCT_PRICE";
    public static final String PRODUCT_QUANTITY = "com.riseinsteps.dailygrocery.PRODUCT_QUANTITY";

    private Context context;
    private List<RecentlyViewedItemModel> recentlyViewedItemModelList;

    public RecentlyViewedItemsAdaptor(Context context, List<RecentlyViewedItemModel> recentlyViewedItemModelList) {
        this.context = context;
        this.recentlyViewedItemModelList = recentlyViewedItemModelList;
    }

    @NonNull
    @Override
    public RecentlyViewedItemsAdaptor.RecentlyViewedItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recently_viewed_item_row,parent,false);
        return new RecentlyViewedItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentlyViewedItemsAdaptor.RecentlyViewedItemHolder holder, int position) {
        RecentlyViewedItemModel recentlyViewedItemModel = recentlyViewedItemModelList.get(position);
        holder.recentlyViewedItemImage.setImageResource(recentlyViewedItemModel.getImage());
        holder.recentlyViewedItemName.setText(recentlyViewedItemModel.getRecentlyItemName());
        holder.recentlyViewedItemDesc.setText(recentlyViewedItemModel.getRecentlyItemDesc());
        holder.recentlyViewedItemPrice.setText(recentlyViewedItemModel.getRecentlyItemPrice());
        holder.recentlyViewedItemQuantity.setText(recentlyViewedItemModel.getRecentlyItemQuantity());
    }

    @Override
    public int getItemCount() {
        return recentlyViewedItemModelList.size();
    }

    public class RecentlyViewedItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView recentlyViewedItemImage;
        private TextView recentlyViewedItemName;
        private TextView recentlyViewedItemDesc;
        private TextView recentlyViewedItemPrice;
        private TextView recentlyViewedItemQuantity;

        public RecentlyViewedItemHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            recentlyViewedItemImage = itemView.findViewById(R.id.recently_viewed_item_image);
            recentlyViewedItemName = itemView.findViewById(R.id.recently_viewed_item_name);
            recentlyViewedItemDesc = itemView.findViewById(R.id.recently_viewed_item_desc);
            recentlyViewedItemPrice = itemView.findViewById(R.id.recently_viewed_item_price);
            recentlyViewedItemQuantity = itemView.findViewById(R.id.recently_viewed_item_quantity);

            recentlyViewedItemImage.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent productDetails = new Intent(context, ProductDetailsActivity.class);
            int pos = getAdapterPosition();
            productDetails.putExtra(PRODUCT_IMAGE,recentlyViewedItemModelList.get(pos).getBIGImage());
            productDetails.putExtra(PRODUCT_ID,recentlyViewedItemModelList.get(pos).getId());
            productDetails.putExtra(PRODUCT_NAME,recentlyViewedItemModelList.get(pos).getRecentlyItemName());
            productDetails.putExtra(PRODUCT_DESC,recentlyViewedItemModelList.get(pos).getRecentlyItemDesc());
            productDetails.putExtra(PRODUCT_PRICE,recentlyViewedItemModelList.get(pos).getRecentlyItemPrice());
            productDetails.putExtra(PRODUCT_QUANTITY,recentlyViewedItemModelList.get(pos).getRecentlyItemQuantity());
            context.startActivity(productDetails);

        }
    }
}
