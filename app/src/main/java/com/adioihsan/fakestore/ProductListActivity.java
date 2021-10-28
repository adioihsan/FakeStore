package com.adioihsan.fakestore;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.adioihsan.fakestore.databinding.ProductListBinding;
import com.adioihsan.fakestore.model.ApiRequestQueue;
import com.adioihsan.fakestore.model.Product;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {
    ProductListBinding bnd;
    ArrayList<Product> productList;
    Intent intProductDetails;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bnd = ProductListBinding.inflate(getLayoutInflater());
        setContentView(bnd.getRoot());

        intProductDetails = new Intent(this, product_details.class);

        productList = new ArrayList<>();
        String url = "https://fakestoreapi.com/products";
       /* JsonArrayRequest reqProductList = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i < response.length();i++){
                    try {
                        JSONObject objProduct = response.getJSONObject(i);
                        Product product = new Product();
                        product.setId(objProduct.getInt("id"));
                        product.setTitle(objProduct.getString("title"));
                        product.setPrice(objProduct.getDouble("price"));
                        product.setDescription(objProduct.getString("description"));
                        product.setCategory(objProduct.getString("category"));
                        product.setImage(objProduct.getString("image"));
                        product.setCount(objProduct.getJSONObject("rating").getInt("count"));
                        product.setRate(objProduct.getJSONObject("rating").getDouble("rate"));
                        productList.add(product);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                bnd.gridProducts.setAdapter(new ProductListAdapter(getApplicationContext(),productList));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });*/

        // ApiRequestQueue.getInstance(this).getRequestQueue().add(reqProductList);
        ApiRequestQueue.getInstance()
                .setRequestQueue(this)
                .getJsonArrayRequest(url)
                .add();
        /*bnd.gridProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                
            }
        });*/
    }
}
