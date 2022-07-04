package com.example.smartlocker;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

public class SingleLockerActivity extends AppCompatActivity {


    Boolean lock = true;
    Button unlock, back;
    ImageView LockImage;
    TextView number, label, position, available, imei;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.single_locker);

        ViewHolder();
        Intent intent = getIntent();
        LockerHolder lockerHolders = (LockerHolder) intent.getSerializableExtra("data");
        try {
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
                if(lockerHolders.getStatus().compareTo("1")==0) {
                    if (lock) {
                        lock = false;
                        LockImage.setBackground(getDrawable(R.drawable.ic_baseline_lock_open_24));
                        unlock.setText("Lock");
                    } else {
                        lock = true;
                        LockImage.setBackground(getDrawable(R.drawable.ic_baseline_lock_24));
                        unlock.setText("Unlock");
                    }
                }else
                    Toast.makeText(SingleLockerActivity.this, "Tủ tạm thời không khả dụng", Toast.LENGTH_LONG).show();


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
    }
}
