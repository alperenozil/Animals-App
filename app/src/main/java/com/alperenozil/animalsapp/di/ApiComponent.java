package com.alperenozil.animalsapp.di;

import com.alperenozil.animalsapp.model.AnimalApi;
import com.alperenozil.animalsapp.model.AnimalApiService;

import dagger.Component;

@Component(modules = {ApiModule.class})
public interface ApiComponent {
    void inject(AnimalApiService service);
}
