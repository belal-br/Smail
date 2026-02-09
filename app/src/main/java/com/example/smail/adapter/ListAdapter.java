package com.example.smail.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smail.R;
import com.example.smail.fragments.CosmeticFillings;
import com.example.smail.fragments.DentalExtraction;
import com.example.smail.fragments.DentalImplants;
import com.example.smail.fragments.DentalVeneers;
import com.example.smail.fragments.FixedDentalProsthesis;
import com.example.smail.fragments.RemovableDentures;
import com.example.smail.fragments.RootCanal;
import com.example.smail.moudle.Service;

import java.util.ArrayList;

public class ListAdapter extends   RecyclerView.Adapter<ListAdapter.ViewHolderClass>{
    ArrayList<Service> services ;
    Fragment fragment;
    public ListAdapter(ArrayList<Service> services, Fragment fragment) {
        this.services = services;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custemlayout,parent,false);
        return new ViewHolderClass(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolderClass holder, int position) {
        holder.txt_nameOfServiceA.setText(services.get(position).getName());
        holder.txt_costA.setText(String.valueOf(services.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return services.size();
    }
    public class ViewHolderClass extends RecyclerView.ViewHolder {
        TextView txt_nameOfServiceA,txt_costA;
        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            txt_nameOfServiceA = itemView.findViewById(R.id.txt_nameOfService);
            txt_costA = itemView.findViewById(R.id.txt_cost);
            itemView.setOnClickListener(v -> {
                Fragment targetFragment;

                if (getAdapterPosition() == 0) {
                    targetFragment = new DentalExtraction();
                } else if (getAdapterPosition() == 1) {
                    targetFragment = new DentalImplants();
                } else
                if (getAdapterPosition() == 2) {
                    targetFragment = new CosmeticFillings();
                } else if (getAdapterPosition() == 3) {
                    targetFragment = new DentalVeneers();
                } else if (getAdapterPosition() == 4) {
                    targetFragment = new FixedDentalProsthesis();
                } else if (getAdapterPosition() == 5) {
                    targetFragment = new RemovableDentures();
                }else
                    targetFragment = new RootCanal();

                fragment.getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.framS, targetFragment)
                        .addToBackStack(null)
                        .commit();
            });
        }
    }
}
