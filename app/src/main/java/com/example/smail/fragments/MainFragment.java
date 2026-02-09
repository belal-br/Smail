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
import com.example.smail.moudle.Service;

import java.util.ArrayList;

public class MainFragment extends Fragment {
    ArrayList<Service> services;
    RecyclerView recyclerView;
    ListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = root.findViewById(R.id.recList);
        services = new ArrayList<>();
        services.add(new Service(1, "Dental Extraction", 150));
        services.add(new Service(2, "Dental Implant", 200));
        services.add(new Service(3, "Cosmetic Fillings", 300));
        services.add(new Service(4, "Dental Veneers", 250));
        services.add(new Service(5, "Fixed Dental Prosthetics", 2000));
        services.add(new Service(6, "Removable Dentures", 2500));
        services.add(new Service(7, "Root Canal", 350));
        adapter = new ListAdapter(services, MainFragment.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(adapter);
        return root;
    }
}