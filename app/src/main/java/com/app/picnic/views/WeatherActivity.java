package com.app.picnic.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.app.picnic.R;
import com.app.picnic.databinding.ActivityWeatherBinding;
import com.app.picnic.models.model_weather;
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

        RecycleAdapter recycleAdapter = new RecycleAdapter();
        binding.recycler.setAdapter(recycleAdapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        binding.setLifecycleOwner(this);

        for(int i = 0;i<10;i++){
            recycleAdapter.addWeather(new model_weather("aaaa","00"+i,"xxxx","xxxxx","xxxx"));
        }

//        binding.btRun.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                //Toast.makeText(getApplicationContext(),""+recycleAdapter.weathers.size(),Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}