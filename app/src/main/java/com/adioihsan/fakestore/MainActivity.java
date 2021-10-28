package com.adioihsan.fakestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.adioihsan.fakestore.databinding.ActivityMainBinding;
import com.adioihsan.fakestore.model.ApiRequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding bnd ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bnd = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bnd.getRoot());

        // request directly from api class | Not working yet.
//        JSONArray arrResponse = ApiRequestQueue.getInstance(MainActivity.this).getJsonArrayRequest("https://fakestoreapi.com/products");
//        if(arrResponse == null)  System.out.println(" response is null");
    }

    public void showProductList(View view) {
        Intent intProductlist = new Intent(MainActivity.this,ProductListActivity.class);
        startActivity(intProductlist);
    }


}