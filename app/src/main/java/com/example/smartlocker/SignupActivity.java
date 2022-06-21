package com.example.smartlocker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    EditText CfPassword;
    Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_signup);
        ViewHolder();



    }
    public void ViewHolder(){
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        CfPassword = findViewById(R.id.cfpassword);
        confirm = findViewById(R.id.confirm_button);
    }
}
