package com.example.smail.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.smail.R;
import com.example.smail.activity.MainActivity;

public class AppointmentF extends Fragment {
    EditText name,age,phone;
    Button book;
    Spinner service;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_appointment, container, false);
        name = root.findViewById(R.id.editTextText);
        age = root.findViewById(R.id.editTextNumber);
        phone = root.findViewById(R.id.editTextPhone);
        service = root.findViewById(R.id.service);
        book = root.findViewById(R.id.btn_book);
        String[] services = {
                "Dental Extraction",
                "Dental Implant",
                "Root Canal",
                "Dental Veneers",
                "Cosmetic Fillings",
                "Removable Dentures",
                "Fixed Dental Prosthesis"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_spinner_item,
                services
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        service.setAdapter(adapter);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(requireActivity(), MainActivity.class);
                startActivity(i);
                Toast.makeText(requireActivity(), "Appointment Booked", Toast.LENGTH_SHORT).show();
            }});
        return root;
    }
}