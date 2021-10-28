package com.adioihsan.fakestore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.adioihsan.fakestore.databinding.ActivityProductDetailsBinding;
import com.adioihsan.fakestore.model.Product;
import com.squareup.picasso.Picasso;

import java.util.Objects;

public class ActivityProductDetails extends AppCompatActivity {
    public static final String EXTRA_PRODUCT = "extra_product";

    ActivityProductDetailsBinding bnd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bnd = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(bnd.getRoot());

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Product product = getIntent().getParcelableExtra(EXTRA_PRODUCT);
        getSupportActionBar().setTitle(product.getTitle());

        String imgUrl = product.getImage();
        Picasso.get().load(imgUrl).placeholder(R.drawable.ic_iconmonstr_shopping_bag).into(bnd.imgProductThumb);
        bnd.txtProductTitle.setText(product.getTitle());
        bnd.txtProductPrice.setText("Rp. "+product.getPrice());
        bnd.imgProductRateStar.setImageResource(getRateStarId(product.getRate()));
        bnd.txtProductSellCount.setText(product.getCount() + " Terjual");
        bnd.txtProductTitle.setText(product.getTitle());
    }

    private int getRateStarId(double rate){
        if(rate == 5.0) return R.drawable.stars_5;
        else if(rate < 5 && rate >= 4.5) return  R.drawable.stars_4_5;
        else if(rate < 4.5 && rate >= 4) return  R.drawable.stars_4;
        else if(rate < 4 && rate >= 3.5) return  R.drawable.stars_3_5;
        else if(rate < 3.5 && rate >= 3) return  R.drawable.stars_3;
        else if(rate < 3 && rate >= 2.5) return  R.drawable.stars_2_5;
        else if(rate < 2.5 && rate >= 2) return  R.drawable.stars_2;
        else if(rate < 2 && rate >= 1.5) return  R.drawable.stars_1_5;
        else if(rate < 1.5 && rate >= 1) return  R.drawable.stars_1;
        else if(rate < 1 && rate >= 0.5) return  R.drawable.stars_0_5;
        else return  R.drawable.stars_0;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
