package com.example.smartlocker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LockerActivity extends AppCompatActivity {

    GridView gvLocker;
    ArrayAdapter<LockerHolder> LockerHolder;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    LockerAdapter lockerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locker);

        recyclerView = findViewById(R.id.RecycleView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        List<LockerHolder> data = new ArrayList<LockerHolder>();

        RequestQueue request = Volley.newRequestQueue(this);
        String url = "http://10.0.2.2:5000/api/Lockers";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);

                                String locker_id = jsonObject.getString("lockerId");
                                String GroupLockerId = jsonObject.getString("groupLockerId");
                                int Number = jsonObject.getInt("number");
                                String Label = jsonObject.getString("label");
                                String Position = jsonObject.getString("position");
                                String available = jsonObject.getString("available");

                                data.add(new LockerHolder(locker_id,GroupLockerId,Label,Position,available,Number));

                                lockerAdapter = new LockerAdapter(data);
                                recyclerView.setAdapter(lockerAdapter);
                                System.out.println("data" + data);

                                Toast.makeText(LockerActivity.this, Number + "",Toast.LENGTH_LONG).show();

                            } catch (JSONException e) {
                                e.printStackTrace();
                                Log.d("AAA",e.toString());
                            }
                            //Toast.makeText(LockerActivity.this, response.length() + "", Toast.LENGTH_LONG).show();
                        }
                    }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LockerActivity.this, "Lỗi",Toast.LENGTH_LONG).show();
                        Log.d("AAA", "Lỗi\n"+ error.toString());

                    }
                });
        request.add(jsonArrayRequest);

//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
//        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(gridLayoutManager);

    }

}