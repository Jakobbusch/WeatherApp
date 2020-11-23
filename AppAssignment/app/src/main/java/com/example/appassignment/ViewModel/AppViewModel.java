package com.example.appassignment.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.appassignment.Model.AppRepository;
import com.example.appassignment.Model.Weather;

public class AppViewModel extends ViewModel {
    AppRepository repository;

    public AppViewModel(){
        repository = AppRepository.getInstance();
    }

    public LiveData<Weather> getTest(){
        return repository.getTest();
    }

    public void updateWeather(String a){
        repository.updateTest(a);
    }
}
