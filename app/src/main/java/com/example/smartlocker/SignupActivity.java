package com.example.smartlocker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class SignupActivity extends AppCompatActivity {

    EditText lockerId,password, CfPassword, employeeId;
    Button confirm, back;
    private int statusCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_signup);
        ViewHolder();
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject jsonObject = new JSONObject();

                try {
                    jsonObject.put("LockerId", Integer.parseInt(lockerId.getText().toString()));
                    jsonObject.put("Password", password.getText().toString());
                    jsonObject.put("EmployeeId", Integer.parseInt(employeeId.getText().toString()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if(password.getText().toString().compareTo(CfPassword.getText().toString()) == 0) {
                    RequestQueue requestQueue = Volley.newRequestQueue(SignupActivity.this);

                    String url = "http://10.0.2.2:5000/api/SignUpLocker";
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, response -> {
                            Toast.makeText(SignupActivity.this, "????ng k?? th??nh c??ng", Toast.LENGTH_LONG).show();
                    }, error -> {
                        Toast.makeText(SignupActivity.this, "B???n ???? ????ng k?? t??? n??y r???i", Toast.LENGTH_LONG).show();
                        Log.d("AAA", error.toString());

                    }){
                    };
                    requestQueue.add(jsonObjectRequest);
                }else {
                    Toast.makeText(SignupActivity.this, "M???t kh???u kh??ng tr??ng kh???p",Toast.LENGTH_LONG).show();
                }


            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });




    }
    public void ViewHolder(){
        lockerId = findViewById(R.id.lockerId);
        password = findViewById(R.id.password);
        CfPassword = findViewById(R.id.cfpassword);
        confirm = findViewById(R.id.confirm_button);
        employeeId = findViewById(R.id.employeeId);
        back = findViewById(R.id.back_button);
    }
}
