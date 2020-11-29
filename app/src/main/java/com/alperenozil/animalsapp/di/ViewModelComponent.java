package com.alperenozil.animalsapp.di;

import com.alperenozil.animalsapp.viewmodel.ListViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {ApiModule.class})
@Singleton
public interface ViewModelComponent {
    void inject(ListViewModel viewModel);
}
