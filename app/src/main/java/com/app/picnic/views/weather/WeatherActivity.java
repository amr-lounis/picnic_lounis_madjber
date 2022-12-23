package com.app.picnic.views.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.app.picnic.R;
import com.app.picnic.databinding.ActivityWeatherBinding;
import com.app.picnic.models.model_weather;

import java.util.List;


public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityWeatherBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_weather);
        WeatherViewModel vm_weather = new ViewModelProvider(this).get(WeatherViewModel.class);


        binding.setVm(vm_weather);
        binding.setLifecycleOwner(this);

        WeatherRecycleAdapter weatherRecycleAdapter = new WeatherRecycleAdapter();
        binding.recycler.setAdapter(weatherRecycleAdapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        binding.setLifecycleOwner(this);

        //-----------------------------------------------------------------------------------------
        vm_weather.listMutableLiveData.observe(this, new Observer<List<model_weather>>() {
            @Override
            public void onChanged(List<model_weather> model_weathers) {
                weatherRecycleAdapter.setWeathers(model_weathers);
            }
        });
        //-----------------------------------------------------------------------------------------
        binding.btRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"get data ",Toast.LENGTH_SHORT).show();
                vm_weather.get_weathet(getApplicationContext());
            }
        });
        //-----------------------------------------------------------------------------------------

    }
}
