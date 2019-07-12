package com.example.danhba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lvContact;
    Contact contact1, contact2, contact3, contact4, contact5;
    List<Contact> contactList;
    AdapterContact adapterContact;
    Button btGroup, btMore;
    RelativeLayout btAdd;
    EditText etSearch;
    Button btSearch;
    //ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Danh bạ");
        lvContact= findViewById(R.id.lvContact);

        contactList= new ArrayList<>();
        contact1= new Contact("Anh", "0362620314", "Friend",true);
        contact2= new Contact("Duong", "0312534784", "FaceBook",false);
        contact3= new Contact("Hoa", "03611122244", "Friend",true);
        contact4= new Contact("Thien", "0366262000", "FaceBook",false);
        contact5= new Contact("Manh", "0365500055", "Home",true);

        contactList.add(contact1);
        contactList.add(contact2);
        contactList.add(contact3);
        contactList.add(contact4);
        contactList.add(contact5);
        //String []ListName= {"Anh", "Mai", "Hoa", "Khoa"};

        adapterContact=new AdapterContact(contactList);

        //arrayAdapter= new ArrayAdapter<String>(this, R.layout.item_contact, ListName);
        lvContact.setAdapter(adapterContact);

        btGroup= findViewById(R.id.btGroup);
        btMore=  findViewById(R.id.btMore);
        btAdd= findViewById(R.id.btnAdd);
        etSearch= findViewById(R.id.etSearch);
        /*btSearch= findViewById(R.id.btSearch);
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Contact> contactArrayList= new ArrayList<>();
                int size= contactList.size();
                for(int i=0; i<size; i++){
                    if(etSearch.toString().equals(contactList.get(i).getName())){
                        contactArrayList.add(contactList.get(i));
                    }
                }
                lvContact.setAdapter(new AdapterContact(contactArrayList));
                //btGroup.setText(String.valueOf(size));
            }
        });*/
        /*etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                MainActivity.this.arrayAdapter.getFilter().filter(charSequence);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });*/
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent= new Intent(getBaseContext(), InforContact.class);
                intent.putExtra("showName", contactList.get(i).getName().toString());
                intent.putExtra("showPhone", contactList.get(i).getPhoneNumber().toString());
                intent.putExtra("showGroup", contactList.get(i).getGroup().toString());
                intent.putExtra("Icon", contactList.get(i).isIcon());
                startActivity(intent);
            }
        });
        btGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getBaseContext(), AddGroup.class);
                startActivity(intent);
            }
        });
        btMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu= new PopupMenu(getBaseContext(), view);
                popupMenu.getMenuInflater().inflate(R.menu.item_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.itRemove:
                                Toast.makeText(getBaseContext(), "Remove", Toast.LENGTH_LONG).show();
                            case R.id.itSetting:
                                Toast.makeText(getBaseContext(), "Setting", Toast.LENGTH_LONG).show();
                            case R.id.itShare:
                                Toast.makeText(getBaseContext(), "Share", Toast.LENGTH_LONG).show();
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getBaseContext(), AddNewContact.class));
            }
        });

        Intent intent= getIntent();
        String strSex= intent.getStringExtra("Sex");
        Boolean iconChoose;
        if(strSex != null ? strSex.equals("Nam") : false)
            iconChoose= true;
        else
            iconChoose= false;
        Contact contact= new Contact(intent.getStringExtra("Name"), intent.getStringExtra("Phone"),
                intent.getStringExtra("Group"), iconChoose);
        contactList.add(contact);
    }

}
