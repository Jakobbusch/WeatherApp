package com.example.appassignment.Model;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppRepository {

    private static AppRepository instance;
    private MutableLiveData<Weather> weather;

    private AppRepository(){
        weather = new MutableLiveData<>();
    }

    public static synchronized AppRepository getInstance(){
        if(instance == null){
            instance = new AppRepository();
        }
        return instance;
    }

    public LiveData<Weather> getTest(){
        return weather;
    }

    public void updateTest(String city){

        API api = ServiceGenerator.getAPI();
        Call<APIResponse> call = api.getWeather("a224e30996f54e5abd3130015201711",city);

        call.enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                if (response.code() == 200){
                    weather.setValue(response.body().getWeather());
                }

                if (response.code() == 401){
                    Log.i("API", "API key not provided.");
                }

                if (response.code() == 400){
                    Log.i("API", "\tNo location found matching parameter 'q'");
                }

                if (response.code() == 403){
                    Log.i("API", "API key has exceeded calls per month quota.");
                }


            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {
                Log.i("Retrofit2", "Something is wrong in the API!");
                t.getMessage();
                t.printStackTrace();
                t.getCause();

            }
        });
    }
}
