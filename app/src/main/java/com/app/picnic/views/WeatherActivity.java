package com.app.picnic.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.app.picnic.R;
import com.app.picnic.databinding.ActivityWeatherBinding;
import com.app.picnic.viewmodels.WeatherViewModel;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        WeatherViewModel vm_weather = new ViewModelProvider(this).get(WeatherViewModel.class);
        ActivityWeatherBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_weather);
        binding.setVm(vm_weather);
        binding.setLifecycleOwner(this);
    }
}