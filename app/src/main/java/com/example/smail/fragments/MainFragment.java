package com.example.smail.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.smail.R;
import com.example.smail.adapter.ListAdapter;
import com.example.smail.db.DB;
import com.example.smail.moudle.Service;

import java.util.ArrayList;

public class MainFragment extends Fragment {
    ArrayList<Service> services;
    RecyclerView recyclerView;
    ListAdapter adapter;
    DB db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = root.findViewById(R.id.recList);
        db = new DB(getContext());
        db.insertService("Dental Extraction", 150);
        db.insertService("Dental Implant", 200);
        db.insertService("Cosmetic Fillings", 300);
        db.insertService("Dental Veneers", 250);
        db.insertService("Fixed Dental Prosthetics", 2000);
        db.insertService("Removable Dentures", 2500);
        db.insertService("Root Canal", 350);
        services = db.getAllServices();
        adapter = new ListAdapter(services, MainFragment.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(adapter);
        return root;
    }
}