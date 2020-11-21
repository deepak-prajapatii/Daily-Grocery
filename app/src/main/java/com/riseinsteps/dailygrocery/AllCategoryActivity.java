package com.riseinsteps.dailygrocery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.riseinsteps.dailygrocery.adaptor.AllCategoryAdaptor;
import com.riseinsteps.dailygrocery.model.AllCategoryModel;

import java.util.ArrayList;
import java.util.List;

public class AllCategoryActivity extends AppCompatActivity {

    private RecyclerView allCategoryRecyclerView;
    private AllCategoryAdaptor allCategoryAdaptor;
    private List<AllCategoryModel> allCategoryModelList;

    private ImageView backViewActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_category);

        backViewActivity = findViewById(R.id.allcategory_back_view);
        backViewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(AllCategoryActivity.this, MainActivity.class);
                startActivity(back);
                finish();
            }
        });

        allCategoryRecyclerView = findViewById(R.id.allcategory_recycler_view);
        allCategoryModelList = new ArrayList<>();
        allCategoryModelList.add(new AllCategoryModel(1, R.drawable.ic_meat));
        allCategoryModelList.add(new AllCategoryModel(2, R.drawable.ic_fish));
        allCategoryModelList.add(new AllCategoryModel(3, R.drawable.ic_fruits));
        allCategoryModelList.add(new AllCategoryModel(4, R.drawable.ic_veggies));
        allCategoryModelList.add(new AllCategoryModel(5, R.drawable.ic_cookies));
        allCategoryModelList.add(new AllCategoryModel(6, R.drawable.ic_egg));
        allCategoryModelList.add(new AllCategoryModel(7, R.drawable.ic_desert));
        allCategoryModelList.add(new AllCategoryModel(8, R.drawable.ic_spices));
        allCategoryModelList.add(new AllCategoryModel(9, R.drawable.ic_juce));
        allCategoryModelList.add(new AllCategoryModel(10, R.drawable.ic_dairy));
        allCategoryModelList.add(new AllCategoryModel(11, R.drawable.ic_salad));

        setAllCategoryRecyclerView(allCategoryModelList);
    }

    private void setAllCategoryRecyclerView(List<AllCategoryModel> allCategoryModelList1) {
        allCategoryRecyclerView.setHasFixedSize(true);
        allCategoryRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        allCategoryRecyclerView.setItemAnimator(new DefaultItemAnimator());
        allCategoryAdaptor = new AllCategoryAdaptor(this, allCategoryModelList1);
        allCategoryRecyclerView.setAdapter(allCategoryAdaptor);
    }


}