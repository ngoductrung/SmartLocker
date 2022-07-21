package com.example.smartlocker;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SingleLockerActivity extends AppCompatActivity {


    Boolean lock = true;
    Button unlock, back;
    ImageView LockImage;
    TextView number, label, position, available, imei;
    EditText LockerPass;
    int LockerId;
    private int statusCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.single_locker);

        ViewHolder();
        Intent intent = getIntent();
        LockerHolder lockerHolders = (LockerHolder) intent.getSerializableExtra("data");
        try {
            LockerId = lockerHolders.getLocker_id();
            number.setText("Số tủ: " + lockerHolders.getNumber());
            label.setText("Nhãn hiệu: "+lockerHolders.getLabel());
            position.setText("Vị trí: "+lockerHolders.getPosition());
            imei.setText("IMEI: "+lockerHolders.getDeviceIMEI());
            if (lockerHolders.getStatus().compareTo("1") == 0)
                available.setText("Sẵn sàng");
            else
                available.setText("Không khả dụng");
        }catch(Exception e){
            e.printStackTrace();
            Log.d("AAA","Lỗi " + e);
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), LockerActivity.class);
                startActivity(intent);
            }
        });



        unlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                JSONObject jsonObject = new JSONObject();

                try {
                    jsonObject.put("LockerId", LockerId);
                    jsonObject.put("Password", LockerPass.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                RequestQueue requestQueue = Volley.newRequestQueue(SingleLockerActivity.this);
                String url = "http://10.0.2.2:5000/api/RegisterLockers";

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject,
                        response ->  {
                                if(statusCode == 400) {
                                        Toast.makeText(SingleLockerActivity.this, "Sai mật khẩu", Toast.LENGTH_LONG).show();
                                    }else{
//                                        Toast.makeText(SingleLockerActivity.this, "" + response, Toast.LENGTH_LONG ).show();
                                        if(lockerHolders.getStatus().compareTo("1")==0) {
                                            if (lock) {
                                                lock = false;
                                                LockImage.setBackground(getDrawable(R.drawable.ic_baseline_lock_open_24));
                                                unlock.setText("Lock");
                                            } else {
                                                lock = true ;
                                                LockImage.setBackground(getDrawable(R.drawable.ic_baseline_lock_24));
                                                unlock.setText("Unlock");
                                            }
                                        }else
                                            Toast.makeText(SingleLockerActivity.this, "Tủ tạm thời không khả dụng", Toast.LENGTH_LONG).show();
                                    }
                        },error -> {
                    Toast.makeText(SingleLockerActivity.this, "Sai mật khẩu" , Toast.LENGTH_LONG).show();
                    Log.d("AAA", error.toString());
                } ){
                    @Override
                    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
                        statusCode = response.statusCode;
                        return super.parseNetworkResponse(response);
                    }
                };

                requestQueue.add(jsonObjectRequest);


            }
        });
    }
    public void ViewHolder(){
        unlock = findViewById(R.id.lock_button);
        LockImage = findViewById(R.id.single_locker_image);
        number = findViewById(R.id.locker_number);
        label = findViewById(R.id.locker_label);
        position = findViewById(R.id.locker_position);
        available = findViewById(R.id.locker_available);
        imei = findViewById(R.id.locker_imei);
        back = findViewById(R.id.back_button);
        LockerPass = findViewById(R.id.LockerPassword);
    }
}
