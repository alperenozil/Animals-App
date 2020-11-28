package com.alperenozil.animalsapp.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.alperenozil.animalsapp.R;
import com.alperenozil.animalsapp.databinding.ItemAnimalBinding;
import com.alperenozil.animalsapp.model.AnimalModel;
import com.alperenozil.animalsapp.util.Util;

import java.util.ArrayList;
import java.util.List;

public class AnimalListAdapter extends RecyclerView.Adapter<AnimalViewHolder> implements AnimalClickListener {
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
        ItemAnimalBinding view= DataBindingUtil.inflate(layoutInflater,R.layout.item_animal,parent,false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        holder.itemView.setAnimal(animalList.get(position));
        holder.itemView.setListener(this);
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    @Override
    public void onClick(View view) {
        for (AnimalModel animal: animalList) {
            if (view.getTag().equals(animal.name)) {
                NavDirections action=ListFragmentDirections.actionListFragmentToDetailFragment(animal);
                Navigation.findNavController(view).navigate(action);
            }
        }
    }
}
