package com.example.appassignment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appassignment.Model.Weather;
import com.example.appassignment.Model.WeatherAdapter;
import com.example.appassignment.ViewModel.AppViewModel;

import java.util.ArrayList;
import java.util.List;

public class Fragment2 extends Fragment {

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_2,container,false);
        recyclerView = v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.hasFixedSize();
         AppViewModel viewModel;
        List<Weather> weatherList = new ArrayList<>();


        viewModel = new ViewModelProvider(this).get(AppViewModel.class);
        viewModel.getTest().observe(getActivity(), new Observer<Weather>() {
            @Override
            public void onChanged(Weather weather) {
             weatherList.add(new Weather(weather.getTemp_c(),weather.getFeelslike_c(),weather.getWind_kph(),weather.getWind_dir(),weather.getHumidity(),weather.getCloud(),weather.getLast_updated()));

            }
        });
        WeatherAdapter adapter = new WeatherAdapter(weatherList);

        recyclerView.setAdapter(adapter);

        return v;
    }
}
