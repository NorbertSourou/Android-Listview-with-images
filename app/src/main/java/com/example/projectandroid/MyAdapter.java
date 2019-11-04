package com.example.projectandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<MyItem> listforview;
    LayoutInflater inflator = null;
    View v;
    ViewHolder vholder;

    public MyAdapter(Context con, ArrayList<MyItem> list) {
        super();
        context = con;
        listforview = list;
        inflator = LayoutInflater.from(con);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return listforview.size();
    }

    @Override
    public Object getItem(int position) {
        return listforview.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        v = convertView;
        if (convertView == null) {
            v = inflator.inflate(R.layout.myadapter, null);
            vholder = new ViewHolder();
            vholder.title = (TextView) v.findViewById(R.id.adaptertextview);
            vholder.title1 = (TextView) v.findViewById(R.id.adaptertextview1);
            vholder.title2 = (TextView) v.findViewById(R.id.adaptertextview2);
            vholder.title3 = (TextView) v.findViewById(R.id.adaptertextview3);
            vholder.image = (ImageView) v.findViewById(R.id.adapterimage);
            v.setTag(vholder);
        } else
            vholder = (ViewHolder) v.getTag();
        MyItem item = (MyItem) listforview.get(position);
        vholder.title.setText(item.getNom());
        vholder.title1.setText(item.getPrenom());
        vholder.title2.setText(item.getContact());
        vholder.title3.setText(item.getEmail());
        vholder.image.setImageResource(item.getImageid());
        return v;
    }

    private class ViewHolder {
        TextView title, title1, title2, title3;
        ImageView image;
    }
}