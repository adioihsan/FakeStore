package com.adioihsan.fakestore;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.adioihsan.fakestore.databinding.ItemProductBinding;
import com.adioihsan.fakestore.model.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class ProductListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Product> productList;
    private LayoutInflater inflater;
    private ItemProductBinding bnd;

    public ProductListAdapter(Context context,ArrayList<Product> productList){
        this.context = context;
        this.productList = productList;
        inflater = LayoutInflater.from(context);
        bnd = ItemProductBinding.inflate(inflater);
    }
    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return productList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            convertView = inflater.inflate(R.layout.item_product,null);
        ImageView imgProductThumb = convertView.findViewById(R.id.imgProductThumb);
        TextView txtProductTitle = convertView.findViewById(R.id.txtProductTitle);
        TextView txtProductPrice = convertView.findViewById(R.id.txtProductPrice);
        ImageView imgProductRateStar = convertView.findViewById(R.id.imgProductRateStar);
        TextView txtProductSellCount = convertView.findViewById(R.id.txtProductSellCount);

        Product product = productList.get(position);
        String imgUrl = product.getImage();
        Picasso.get().load(imgUrl).placeholder(R.drawable.ic_iconmonstr_shopping_bag).into(imgProductThumb);
        txtProductTitle.setText(product.getTitle());
        txtProductPrice.setText("Rp. "+product.getPrice());
        imgProductRateStar.setImageResource(getRateStarId(product.getRate()));
        txtProductSellCount.setText(product.getCount() + " Terjual");
        txtProductTitle.setText(productList.get(position).getTitle());
        return  convertView;
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
}
