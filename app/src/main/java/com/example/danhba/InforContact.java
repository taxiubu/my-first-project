package com.example.danhba;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class InforContact extends AppCompatActivity {
    TextView tvShowName, tvShowPhone, tvShowGroup;
    Button btBack;
    ImageView imageView;
    Button btCall, btMess, btEdit;
    int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor_contact);
        getSupportActionBar().setTitle("Thông tin");

        tvShowName= findViewById(R.id.tvShowName);
        tvShowGroup= findViewById(R.id.tvShowGroup);
        tvShowPhone= findViewById(R.id.tvShowPhone);
        btBack= findViewById(R.id.btBack);
        imageView= findViewById(R.id.imIcon);

        final Intent intent= getIntent();
        tvShowName.setText("Tên: "+intent.getStringExtra("showName"));
        tvShowGroup.setText("Nhóm: "+intent.getStringExtra("showGroup"));
        tvShowPhone.setText("Số điện thoại: "+intent.getStringExtra("showPhone"));
        Boolean chooseIcon= intent.getBooleanExtra("Icon", true);

        if(chooseIcon)
            imageView.setImageResource(R.drawable.men);
        else
            imageView.setImageResource(R.drawable.women);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btCall= findViewById(R.id.btCall);
        btMess= findViewById(R.id.btMess);
        btEdit= findViewById(R.id.btEdit);
        btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent(getBaseContext(), EditContact.class);
                //a= 1;
                startActivity(intent1);
            }
        });

        btCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Call", Toast.LENGTH_LONG).show();

            }
        });

        btMess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Mess", Toast.LENGTH_LONG).show();
            }
        });
    }

    /*@Override
    protected void onResume() {
        Intent intent= getIntent();
        tvShowName.setText("Tên: "+intent.getStringExtra("EditName"));
        //tvShowGroup.setText("Nhóm: "+intent.getStringExtra("showGroup"));
        tvShowPhone.setText("Số điện thoại: "+intent.getStringExtra("EditPhone"));

        super.onResume();
    }*/
}
