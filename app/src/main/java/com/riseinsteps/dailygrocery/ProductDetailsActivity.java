package com.riseinsteps.dailygrocery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static com.riseinsteps.dailygrocery.adaptor.RecentlyViewedItemsAdaptor.PRODUCT_DESC;
import static com.riseinsteps.dailygrocery.adaptor.RecentlyViewedItemsAdaptor.PRODUCT_ID;
import static com.riseinsteps.dailygrocery.adaptor.RecentlyViewedItemsAdaptor.PRODUCT_IMAGE;
import static com.riseinsteps.dailygrocery.adaptor.RecentlyViewedItemsAdaptor.PRODUCT_NAME;
import static com.riseinsteps.dailygrocery.adaptor.RecentlyViewedItemsAdaptor.PRODUCT_PRICE;
import static com.riseinsteps.dailygrocery.adaptor.RecentlyViewedItemsAdaptor.PRODUCT_QUANTITY;

public class ProductDetailsActivity extends AppCompatActivity {

    private ImageView productDetailsImage;
    private TextView productDetailsName;
    private TextView productDetailsDesc;
    private TextView productDetailsPrice;
    private TextView productDetailsQuantity;

    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        back = findViewById(R.id.product_details_back_view);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIntent =  new Intent(ProductDetailsActivity.this, MainActivity.class);
                startActivity(backIntent);
                finish();
            }
        });



        Intent details = getIntent();
        String productId = details.getStringExtra(PRODUCT_ID);
        int productImage = details.getIntExtra(PRODUCT_IMAGE, R.drawable.b1);
        String productName = details.getStringExtra(PRODUCT_NAME);
        String productDesc = details.getStringExtra(PRODUCT_DESC);
        String productPrice = details.getStringExtra(PRODUCT_PRICE);
        String productQuantity = details.getStringExtra(PRODUCT_QUANTITY);

        productDetailsImage = findViewById(R.id.product_image);
        productDetailsName = findViewById(R.id.product_name);
        productDetailsDesc = findViewById(R.id.product_decription);
        productDetailsPrice = findViewById(R.id.product_price);
        productDetailsQuantity = findViewById(R.id.product_quantity);


        productDetailsImage.setImageResource(productImage);
        productDetailsName.setText(productName);
        productDetailsDesc.setText(productDesc);
        productDetailsPrice.setText(productPrice);
        productDetailsQuantity.setText(productQuantity);


    }
}