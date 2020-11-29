package com.alperenozil.animalsapp.model;

import com.alperenozil.animalsapp.di.DaggerApiComponent;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class AnimalApiService {
    @Inject
    AnimalApi animalApi;

    public AnimalApiService() {
        DaggerApiComponent.create().inject(this);
    }

    public Single<ApiKeyModel> getApiKey(){
        return animalApi.getApiKey();
    }
    public Single<List<AnimalModel>> getAnimals(String key){
        return animalApi.getAnimals(key);
    }
}
