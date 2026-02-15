package com.example.smail.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smail.R;
import com.example.smail.moudle.Doctors;

import java.util.ArrayList;

public class DoctorAdapter extends BaseAdapter {
    Context context;
    ArrayList<Doctors> doctors;
    LayoutInflater inflater ;
    public DoctorAdapter(Context context, ArrayList<Doctors> itemArrayList) {
        this.context = context;
        this.doctors = itemArrayList;
        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return doctors.size();
    }

    @Override
    public Object getItem(int position) {
        return doctors.get(position);
    }

    @Override
    public long getItemId(int position) {
        return doctors.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View root = inflater.inflate(R.layout.custem_doctor,null);
        TextView name = root.findViewById(R.id.doctorName);
        TextView email = root.findViewById(R.id.doctorEmail);
        TextView phone = root.findViewById(R.id.doctorPhone);
        name.setText(doctors.get(position).getName());
        email.setText(doctors.get(position).getEmail());
        phone.setText(doctors.get(position).getPhone());
        return root;
    }

}
