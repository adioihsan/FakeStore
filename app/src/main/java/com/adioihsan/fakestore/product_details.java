package com.adioihsan.fakestore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.adioihsan.fakestore.databinding.ActivityProductDetailsBinding;

public class product_details extends AppCompatActivity {
    ActivityProductDetailsBinding bnd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bnd = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(bnd.getRoot());

    }
}