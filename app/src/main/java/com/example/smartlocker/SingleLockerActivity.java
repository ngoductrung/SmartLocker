package com.example.smartlocker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SingleLockerActivity extends AppCompatActivity {

    Button unlock;
    ImageView LockImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.single_locker);

        unlock = findViewById(R.id.lock_button);
        LockImage = findViewById(R.id.single_locker_image);

        unlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
