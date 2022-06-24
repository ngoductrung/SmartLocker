package com.example.smartlocker;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SingleLockerActivity extends AppCompatActivity {


    Boolean lock = true;
    Button unlock;
    ImageView LockImage;
    TextView number, label, position, available, imei;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.single_locker);

        ViewHolder();

        try {
            Intent intent = getIntent();
            LockerHolder lockerHolders = (LockerHolder) intent.getSerializableExtra("data");

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
            Log.d("AAA","Lỗi " + e.toString());
        }



        unlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


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
    }
}
