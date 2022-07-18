package com.example.smartlocker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {

    EditText lockerId;
    EditText password;
    EditText CfPassword;
    Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_signup);
        ViewHolder();
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }
    public void ViewHolder(){
        lockerId = findViewById(R.id.lockerId);
        password = findViewById(R.id.password);
        CfPassword = findViewById(R.id.cfpassword);
        confirm = findViewById(R.id.confirm_button);
    }
}
