package com.alperenozil.animalsapp.view;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alperenozil.animalsapp.databinding.ItemAnimalBinding;

public class AnimalViewHolder extends RecyclerView.ViewHolder {
    ItemAnimalBinding itemView;
    public AnimalViewHolder(@NonNull ItemAnimalBinding view) {
        super(view.getRoot());
        itemView=view;
    }
}
