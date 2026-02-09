package com.example.smail.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.smail.R;
import com.example.smail.activity.Appointment;

public class DentalExtraction extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dental_extraction, container, false);
        Button btn = root.findViewById(R.id.btn_appointment);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(requireActivity(), Appointment.class);
                startActivity(i);
            }});
        return root;
    }
}