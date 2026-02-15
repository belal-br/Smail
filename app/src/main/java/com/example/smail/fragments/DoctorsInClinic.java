package com.example.smail.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.smail.R;
import com.example.smail.adapter.DoctorAdapter;
import com.example.smail.api.AppController;
import com.example.smail.moudle.Doctors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

public class DoctorsInClinic extends Fragment {

    ArrayList<Doctors> doctorsA;
    ListView listView;
    DoctorAdapter adapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_doctors_in_clinic, container, false);

        doctorsA = new ArrayList<>();
        listView = root.findViewById(R.id.doctorList);

        adapter = new DoctorAdapter(getContext(), doctorsA);
        listView.setAdapter(adapter);

        getDoctor();

        return root;
    }

    private void getDoctor() {

        String link = AppController.link;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, link, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        try {
                            JSONArray doctors = jsonObject.getJSONArray("users");
                            for (int i = 0; i < doctors.length(); i++) {
                                JSONObject doctor = doctors.getJSONObject(i);
                                int id = doctor.getInt("id");
                                String fname = doctor.getString("firstName");
                                String lname = doctor.getString("lastName");
                                String email = doctor.getString("email");
                                String phone = doctor.getString("phone");
                                Doctors doctors1 = new Doctors(id, fname + " " + lname, email, phone);
                                doctorsA.add(doctors1);
                            }
                            adapter.notifyDataSetChanged(); // Notify the adapter that the data has changed

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getContext(), "JSON Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(getContext(), volleyError.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return super.getHeaders();
            }
        };

        AppController.getInstance().addToRequestQueue(jsonObjectRequest);
    }
}
