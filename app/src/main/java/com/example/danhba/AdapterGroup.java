package com.example.danhba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class AdapterGroup extends BaseAdapter {
    List<Group> groupList;

    public AdapterGroup(List<Group> groupList) {
        this.groupList = groupList;
    }

    @Override
    public int getCount() {
        return groupList.size();
    }

    @Override
    public Object getItem(int i) {
        return groupList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater= LayoutInflater.from(viewGroup.getContext());
        View v= layoutInflater.inflate(R.layout.item_contact, viewGroup, false);
        TextView tvGroup= v.findViewById(R.id.tvName);
        Group group= groupList.get(i);
        tvGroup.setText(group.getStrGroup());
        return v;
    }
}
