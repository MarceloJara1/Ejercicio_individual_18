package com.example.ejercicioindividual18;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.ejercicioindividual18.databinding.FragmentBlank2Binding;

public class BlankFragment2 extends Fragment {

    FragmentBlank2Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentBlank2Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

        Bundle bundle = getArguments();
        if (bundle!=null){
            String imageUrl = bundle.getString("image_url");
            String description = bundle.getString("description");

            //Cargar la imagen con Glide
            Glide.with(requireContext())
                    .load(imageUrl)
                    .into(binding.imgFragment2);
            //Mostrar la descripcion
            binding.txtDescription.setText(description);

        }
        MainActivity mainActivity = (MainActivity) requireActivity();
        mainActivity.binding.btnBack.setVisibility(View.VISIBLE);


        return view;
    }
}