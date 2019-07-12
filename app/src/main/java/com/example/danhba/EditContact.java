package com.example.danhba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class EditContact extends AppCompatActivity {
    Spinner spinnerEdit;
    Button btEditCancel, btEditOk;
    EditText etEditName, etEditPhone;
    String editGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        getSupportActionBar().setTitle("Sửa");
        spinnerEdit= findViewById(R.id.spEditTypeGroup);
        ArrayList<String> typeGroup= new ArrayList<>();
        typeGroup.add("FaceBook");
        typeGroup.add("Friend");
        typeGroup.add("Home");
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>(getBaseContext(),
                android.R.layout.simple_list_item_1, typeGroup);
        spinnerEdit.setAdapter(arrayAdapter);

        btEditCancel= findViewById(R.id.btEditCancel);
        btEditOk= findViewById(R.id.btEditOk);

        btEditCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btEditOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getBaseContext(), InforContact.class);
                intent.putExtra("EditName", etEditName.getText().toString());
                intent.putExtra("EditPhone", etEditPhone.getText().toString());
                intent.putExtra("EditGroup", "Group Other");
                startActivity(intent);
                Toast.makeText(getBaseContext(), "Edit Complete", Toast.LENGTH_LONG).show();
                onBackPressed();
            }
        });
    }
}
