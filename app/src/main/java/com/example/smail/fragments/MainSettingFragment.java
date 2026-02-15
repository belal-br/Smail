package com.example.smail.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.smail.R;


public class MainSettingFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_main_setting, container, false);
        LinearLayout personalS = root.findViewById(R.id.personalS);
        LinearLayout contactUsS = root.findViewById(R.id.contactUsS);
        LinearLayout aboutUsS = root.findViewById(R.id.aboutUsS);
        Button btn_logout = root.findViewById(R.id.btn_logout);
        personalS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.framS, new DoctorsInClinic()).addToBackStack(null).commit();
            }
        });
        contactUsS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.framS, new ContactFragment()).addToBackStack(null).commit();
            }
        });
        aboutUsS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.framS, new AboutUsFragment()).addToBackStack(null).commit();
            }
        });
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return root;
    }
}