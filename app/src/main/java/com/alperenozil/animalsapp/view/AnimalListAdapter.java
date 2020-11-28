package com.alperenozil.animalsapp.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.alperenozil.animalsapp.R;
import com.alperenozil.animalsapp.model.AnimalModel;
import com.alperenozil.animalsapp.util.Util;

import java.util.ArrayList;
import java.util.List;

public class AnimalListAdapter extends RecyclerView.Adapter<AnimalViewHolder> {
    private ArrayList<AnimalModel> animalList=new ArrayList<>();
    public void updateAnimalList(List<AnimalModel> newAnimalList){
        animalList.clear();
        animalList.addAll(newAnimalList);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_animal,parent,false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        ImageView imageView=holder.itemView.findViewById(R.id.imageView);
        TextView textView=holder.itemView.findViewById(R.id.textView);
        textView.setText(animalList.get(position).name);
        Util.loadImage(imageView,animalList.get(position).imageUrl,Util.getProgressDrawable(imageView.getContext()));
        imageView.setOnClickListener(v -> {
            NavDirections action=ListFragmentDirections.actionListFragmentToDetailFragment();
            Navigation.findNavController(v).navigate(action);
        });
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }
}
