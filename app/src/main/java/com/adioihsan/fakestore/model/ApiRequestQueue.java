package com.adioihsan.fakestore.model;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

public class ApiRequestQueue {
    private static ApiRequestQueue instance;
    private RequestQueue requestQueue;
    JSONArray arrResponse;
    private Context context;

    private ApiRequestQueue(Context context){
        this.context = context;
    }
    public static synchronized ApiRequestQueue getInstance(Context context){
        if(instance == null){
            instance = new ApiRequestQueue(context);
        }
        return instance;
    };
    public RequestQueue getRequestQueue(){
        if(requestQueue == null){
            requestQueue = new Volley().newRequestQueue(context);
        }
        return requestQueue;
    }

    // Request directly in api class  | Not Working yet
//    public JSONArray getJsonArrayRequest(String url){
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        arrResponse = response;
//                        try {
//                            String title = response.getJSONObject(1).getString("title");
//                            Log.d("respon","Respone is : "+title);
//                            System.out.println("respon : "+title);
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                },error -> {
//
//        });
//        return arrResponse;
//    }
}
