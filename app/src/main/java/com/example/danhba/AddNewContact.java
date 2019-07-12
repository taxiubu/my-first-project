package com.example.danhba;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddNewContact extends AppCompatActivity {
    Spinner spinner;
    Button btCancel, btOk, btTune;
    Button btSex;
    EditText etName, etPhone;
    String group;
    TextView tvSex, tvTune;
    Contact contact;
    ArrayList<String> typeGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);
        getSupportActionBar().setTitle("Thêm danh bạ");
        spinner= findViewById(R.id.spTypeGroup);
        typeGroup= new ArrayList<>();
        typeGroup.add("FaceBook");
        typeGroup.add("Friend");
        typeGroup.add("Home");

        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>(getBaseContext(),
                android.R.layout.simple_list_item_1, typeGroup);
        spinner.setAdapter(arrayAdapter);

        etName= findViewById(R.id.etName);
        etPhone= findViewById(R.id.etNumberPhone);
        tvSex= findViewById(R.id.tvSex);
        tvTune= findViewById(R.id.tvTune);


        btCancel= findViewById(R.id.btCancel);
        btOk= findViewById(R.id.btOK);
        btTune= findViewById(R.id.btTune);

        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        spinner.setOnItemSelectedListener(new SuKien());


        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(getBaseContext(), MainActivity.class);
                intent.putExtra("Name", etName.getText().toString());
                intent.putExtra("Phone", etPhone.getText().toString());
                intent.putExtra("Group", group);
                intent.putExtra("Sex", tvSex.getText().toString());
                startActivity(intent);
                Toast.makeText(getBaseContext(), "OK", Toast.LENGTH_LONG).show();
                onBackPressed();
            }
        });

        btTune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] tunes= {"Hãy trao cho anh", "Chạy ngay đi", "Nơi này có anh" ,
                        "Cơn mưa ngang qua", "Âm thâm bên em", "Lạc trôi"};
                AlertDialog dialog= new AlertDialog.Builder(AddNewContact.this)
                        .setTitle("Set ring tune")
                        .setSingleChoiceItems(tunes, 1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getBaseContext(), tunes[i], Toast.LENGTH_LONG).show();
                                tvTune.setText(tunes[i]);
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getBaseContext(), "OK", Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getBaseContext(), "Cancel", Toast.LENGTH_LONG).show();
                            }
                        })
                        .create();
                dialog.show();
            }
        });
        btSex= findViewById(R.id.btSex);
        btSex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] SEX= {"Nam", "Nữ"};
                AlertDialog alertDialog= new AlertDialog.Builder(AddNewContact.this)
                        .setTitle("Chọn giới tính")
                        .setSingleChoiceItems(SEX, 1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                tvSex.setText(SEX[i]);
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getBaseContext(), "OK", Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getBaseContext(), "Cancel", Toast.LENGTH_LONG).show();
                            }
                        })
                        .create();
                alertDialog.show();
            }
        });
    }

    private class SuKien implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            group= typeGroup.get(i);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
            group= "";
        }
    }
}
