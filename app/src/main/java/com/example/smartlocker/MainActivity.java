package com.example.smartlocker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button LoginButton;
    Button SigupButton;
    EditText Account;
    EditText Password;
//    String account, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        ViewHolder();
        SigupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LockerActivity.class);
                startActivity(intent);
            }
        });
//        RequestQueue request = Volley.newRequestQueue(this);
//        String url = "http://10.0.2.2:5000/api/Login";
//        LoginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                account = Account.getText().toString();
//                password = Password.getText().toString();
//
//                JSONArray jsonArray = new JSONArray();
//                JSONObject jsonObject = new JSONObject();
//
//                try {
//                    jsonObject.put("UserName",account);
//                    jsonObject.put("Password", password);
//                    jsonArray.put(jsonObject);
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//                JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST,url,jsonArray, response -> {
//                    if(response.length()>10){
//                        Intent intent = new Intent(MainActivity.this, LockerActivity.class);
//                        startActivity(intent);
//                    }else
//                        Toast.makeText(MainActivity.this, "Sai tài khoản hoặc sai mật khẩu", Toast.LENGTH_LONG);
//
//
//                },error -> {
//                    Toast.makeText(MainActivity.this, "Lỗi",Toast.LENGTH_LONG).show();
//                    Log.d("AAA", "Lỗi\n"+ error.toString());
//                });
//            }
//        });
    }
    public void ViewHolder(){
        LoginButton = findViewById(R.id.login);
        SigupButton = findViewById(R.id.signup);
//        Account = findViewById(R.id.account);
//        Password = findViewById(R.id.password);
    }
}
