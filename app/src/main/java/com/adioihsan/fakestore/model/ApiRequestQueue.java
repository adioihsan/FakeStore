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
    private static ApiRequestQueue instance = null;
    private RequestQueue requestQueue;
    private JsonArrayRequest arrayRequest;

    public static synchronized ApiRequestQueue getInstance(){
        if(instance == null){
            instance = new ApiRequestQueue();
        }
        return instance;
    };

    public RequestQueue getRequestQueue(Context context){
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(context);
        }
        return requestQueue;
    }

    public ApiRequestQueue setRequestQueue(Context context){
        requestQueue = Volley.newRequestQueue(context);
        return instance;
    }

    public void add(){
        requestQueue.add(arrayRequest);
    } 

    // Request directly in api class  | Not Working yet
    public ApiRequestQueue getJsonArrayRequest(String url){
        arrayRequest =  new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            String title = response.getJSONObject(1).getString("title");
                            Log.d("respon", "Respone is : " + title);
                            System.out.println("respon : " + title);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, error -> {
            Log.d("respon", "getJsonArrayRequest: GAGAL MENDAPATKAN DATA");
        });
        return instance;
    }
}
