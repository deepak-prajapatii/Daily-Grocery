package com.riseinsteps.dailygrocery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.riseinsteps.dailygrocery.adaptor.CategoryAdaptor;
import com.riseinsteps.dailygrocery.adaptor.DiscountedItemsAdaptor;
import com.riseinsteps.dailygrocery.adaptor.RecentlyViewedItemsAdaptor;
import com.riseinsteps.dailygrocery.model.CategoryModel;
import com.riseinsteps.dailygrocery.model.DiscountedItemsModel;
import com.riseinsteps.dailygrocery.model.RecentlyViewedItemModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView discountedRecyclerView, categoryRecyclerView, recentlyViewItemRecyclerView;
    private DiscountedItemsAdaptor discountedItemsAdaptor;
    private List<DiscountedItemsModel> discountedItemsModelList;

    private CategoryAdaptor categoryAdaptor;
    private List<CategoryModel> categoryModelList;

    private RecentlyViewedItemsAdaptor recentlyViewedItemsAdaptor;
    private List<RecentlyViewedItemModel> recentlyViewedItemModelList;

    private TextView allCategoryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        discountedRecyclerView = findViewById(R.id.discounted_recycler_view);
        categoryRecyclerView = findViewById(R.id.category_recycler_view);
        recentlyViewItemRecyclerView = findViewById(R.id.recently_viewed_recycler_view);

        discountedItemsModelList = new ArrayList<>();
        discountedItemsModelList.add(new DiscountedItemsModel(1, R.drawable.discountberry));
        discountedItemsModelList.add(new DiscountedItemsModel(2, R.drawable.discountbrocoli));
        discountedItemsModelList.add(new DiscountedItemsModel(3, R.drawable.discountmeat));
        discountedItemsModelList.add(new DiscountedItemsModel(4, R.drawable.discountberry));
        discountedItemsModelList.add(new DiscountedItemsModel(5, R.drawable.discountbrocoli));
        discountedItemsModelList.add(new DiscountedItemsModel(6, R.drawable.discountmeat));


        allCategoryView = findViewById(R.id.all_category);
        allCategoryView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent allCategoryActivity = new Intent(MainActivity.this, AllCategoryActivity.class);
                startActivity(allCategoryActivity);
            }
        });

        categoryModelList = new ArrayList<>();
        categoryModelList.add(new CategoryModel(1, R.drawable.ic_cookies));
        categoryModelList.add(new CategoryModel(2, R.drawable.ic_meat));
        categoryModelList.add(new CategoryModel(3, R.drawable.ic_fruits));
        categoryModelList.add(new CategoryModel(4, R.drawable.ic_veggies));
        categoryModelList.add(new CategoryModel(5, R.drawable.ic_fish));
        categoryModelList.add(new CategoryModel(6, R.drawable.ic_fruits));
        categoryModelList.add(new CategoryModel(7, R.drawable.ic_veggies));
        categoryModelList.add(new CategoryModel(8, R.drawable.ic_fish));

        recentlyViewedItemModelList = new ArrayList<>();
        recentlyViewedItemModelList.add(new RecentlyViewedItemModel(1, R.drawable.card1, R.drawable.b2, "Kiwi"
                , "Full of Nutrients like Vitamin C, E,  K and pottasium", "Rs. 30", "1PC"));
        recentlyViewedItemModelList.add(new RecentlyViewedItemModel(2, R.drawable.card2, R.drawable.b1, "Strawberry"
                , "The Strawberry is highly nutritious fruit, loaded with vitamin C.", "Rs. 30", "1KG"));
        recentlyViewedItemModelList.add(new RecentlyViewedItemModel(3, R.drawable.card3, R.drawable.b3, "Papaya"
                , "Papaya are spherical or pear-shaped fruits that can be as lng as 20 inches", "Rs. 80", "1KG"));
        recentlyViewedItemModelList.add(new RecentlyViewedItemModel(4, R.drawable.card4, R.drawable.b4, "Watermelon"
                , "Watermelon has high water content and also provides some fiber", "Rs. 80", "1KG"));


        setDiscountedRecyclerView(discountedItemsModelList);
        setCategoryRecyclerView(categoryModelList);
        setRecentlyViewedItemRecyclerView(recentlyViewedItemModelList);
    }

    private void setRecentlyViewedItemRecyclerView(List<RecentlyViewedItemModel> recentlyViewedItemModelList1) {
        recentlyViewItemRecyclerView.setHasFixedSize(true);
        recentlyViewItemRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recentlyViewedItemsAdaptor = new RecentlyViewedItemsAdaptor(this, recentlyViewedItemModelList1);
        recentlyViewItemRecyclerView.setAdapter(recentlyViewedItemsAdaptor);
    }

    private void setCategoryRecyclerView(List<CategoryModel> categoryModelList1) {
        categoryRecyclerView.setHasFixedSize(true);
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
        categoryAdaptor = new CategoryAdaptor(MainActivity.this, categoryModelList1);
        categoryRecyclerView.setAdapter(categoryAdaptor);
    }

    private void setDiscountedRecyclerView(List<DiscountedItemsModel> discountedItemsModelList1) {
        discountedRecyclerView.setHasFixedSize(true);
        discountedRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
        discountedItemsAdaptor = new DiscountedItemsAdaptor(MainActivity.this, discountedItemsModelList1);
        discountedRecyclerView.setAdapter(discountedItemsAdaptor);
    }
}