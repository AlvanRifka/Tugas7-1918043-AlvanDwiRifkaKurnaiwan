package com.example.tugas7_1918043_alvan;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Kacamata> Kacamata;
    public CustomListAdapter(Activity activity, List<Kacamata> Kacamata) {
        this.activity = activity;
        this.Kacamata = Kacamata;
    }
    @Override
    public int getCount() {
        return Kacamata.size();
    }
    @Override
    public Object getItem(int location) {
        return Kacamata.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null) inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) convertView = inflater.inflate(R.layout.custom_list, null);
        TextView nama = (TextView) convertView.findViewById(R.id.text_nama);
        TextView jenis = (TextView) convertView.findViewById(R.id.text_jenis);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.iconid);
        Kacamata m = Kacamata.get(position);
        nama.setText("Nama : "+ m.get_nama());
        jenis.setText("Kelas : "+ m.get_jenis());
        return convertView;
    }
}

