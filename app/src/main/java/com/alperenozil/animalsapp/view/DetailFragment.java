package com.alperenozil.animalsapp.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alperenozil.animalsapp.R;
import com.alperenozil.animalsapp.databinding.FragmentDetailBinding;
import com.alperenozil.animalsapp.model.AnimalModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailFragment extends Fragment {
    private AnimalModel animalModel;
    FragmentDetailBinding animalDetailBinding;
    public DetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        animalDetailBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_detail,container,false);
        return animalDetailBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            animalModel = DetailFragmentArgs.fromBundle(getArguments()).getAnimalModel();
        }
        if (animalModel!=null) {
            animalDetailBinding.setAnimal(animalModel);
        }
    }
}