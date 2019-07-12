package com.example.danhba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddGroup extends AppCompatActivity {
    ListView lvGroup;
    Group group1, group2, group3;
    List<Group> groupList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_group);
        getSupportActionBar().setTitle("Nhóm");

        lvGroup= findViewById(R.id.lvGroup);
        group1= new Group("Home");
        group2= new Group("Friend");
        group3= new Group("Facebook");

        groupList= new ArrayList<>();
        groupList.add(group1);
        groupList.add(group2);
        groupList.add(group3);

        AdapterGroup adapterGroup= new AdapterGroup(groupList);
        lvGroup.setAdapter(adapterGroup);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itNewBack:
                finish();
                break;
            case R.id.itBlue:
                lvGroup.setBackgroundResource(R.color.colorBlue);
                Toast.makeText(getBaseContext(), "Change Complete", Toast.LENGTH_LONG).show();
                break;
            case R.id.itWhite:
                lvGroup.setBackgroundResource(R.color.colorWhite);
                Toast.makeText(getBaseContext(), "Change Complete", Toast.LENGTH_LONG).show();
                break;
            case R.id.itNewRemove:
                Toast.makeText(getBaseContext(), "Remove Complete", Toast.LENGTH_LONG).show();
                break;
            case R.id.itNewAdd:
                Toast.makeText(getBaseContext(), "Add Complete", Toast.LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
