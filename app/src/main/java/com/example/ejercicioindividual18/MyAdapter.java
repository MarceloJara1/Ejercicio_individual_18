package com.example.ejercicioindividual18;


import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ejercicioindividual18.databinding.DataListItemBinding;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<ImageItem> imageItems;
    private OnItemClickListener onItemClickListener;

    public MyAdapter(Context context, List<ImageItem> imageItems) {
        this.context = context;
        this.imageItems = imageItems;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DataListItemBinding binding = DataListItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ImageItem item = imageItems.get(position);

        Glide.with(context)
                .load(item.getImageUrl())
                .into(holder.imageView);
        holder.txtDesc.setText(item.getNombre());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(imageItems.get(position));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return imageItems.size();
    }

    public interface OnItemClickListener {
        void onItemClick(ImageItem item);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

}
