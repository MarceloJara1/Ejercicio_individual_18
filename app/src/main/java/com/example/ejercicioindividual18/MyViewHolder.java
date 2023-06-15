package com.example.ejercicioindividual18;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejercicioindividual18.databinding.DataListItemBinding;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView txtDesc;

    DataListItemBinding binding;

    public MyViewHolder(@NonNull DataListItemBinding binding) {
        super(binding.getRoot());

        imageView = binding.imgDataList;
        txtDesc = binding.txtView;

    }
}
