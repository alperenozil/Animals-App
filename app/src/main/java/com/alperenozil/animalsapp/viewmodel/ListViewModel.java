package com.alperenozil.animalsapp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alperenozil.animalsapp.model.AnimalApiService;
import com.alperenozil.animalsapp.model.AnimalModel;
import com.alperenozil.animalsapp.model.ApiKeyModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ListViewModel extends ViewModel {
    private AnimalApiService animalApiService = new AnimalApiService();
    private CompositeDisposable disposable = new CompositeDisposable();
    public MutableLiveData<List<AnimalModel>> animals = new MutableLiveData<List<AnimalModel>>();
    public MutableLiveData<Boolean> loadError = new MutableLiveData<Boolean>();
    public MutableLiveData<Boolean> loading = new MutableLiveData<Boolean>();

    public void refresh() {
        loading.setValue(true);
        getKey();
    }

    private void getKey() {
        disposable.add(animalApiService.getApiKey().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<ApiKeyModel>() {
            @Override
            public void onSuccess(@NonNull ApiKeyModel apiKeyModel) {
                if (apiKeyModel.key.isEmpty()) {
                    loadError.setValue(true);
                    loading.setValue(false);
                } else {
                    getAnimals(apiKeyModel.key);
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
                loading.setValue(false);
                loadError.setValue(true);
            }
        }));
    }

    private void getAnimals(String key) {
        disposable.add(
                animalApiService.getAnimals(key).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<List<AnimalModel>>() {

                    @Override
                    public void onSuccess(@NonNull List<AnimalModel> animalModels) {
                        loadError.setValue(false);
                        animals.setValue(animalModels);
                        loading.setValue(false);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                        loading.setValue(false);
                        loadError.setValue(true);
                    }
                })
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
