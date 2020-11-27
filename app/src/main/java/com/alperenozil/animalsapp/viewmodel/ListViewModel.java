package com.alperenozil.animalsapp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alperenozil.animalsapp.model.AnimalModel;

import java.util.ArrayList;
import java.util.List;

public class ListViewModel extends ViewModel {
    public MutableLiveData<List<AnimalModel>> animals=new MutableLiveData<List<AnimalModel>>();
    public MutableLiveData<Boolean> loadError=new MutableLiveData<Boolean>();
    public MutableLiveData<Boolean> loading=new MutableLiveData<Boolean>();

    public void refresh(){
        AnimalModel animal=new AnimalModel("lion");
        AnimalModel animal1=new AnimalModel("cat");
        AnimalModel animal2=new AnimalModel("crocodile");
        List<AnimalModel> animalList=new ArrayList<>();
        animalList.add(animal);
        animalList.add(animal1);
        animalList.add(animal2);
        animals.setValue(animalList);
        loadError.setValue(false);
        loading.setValue(false);
    }
}
