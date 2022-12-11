package com.app.picnic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.app.picnic.databinding.ActivityMainBinding;
import com.app.picnic.viewmodels.WeatherViewModel;

public class MainActivity extends AppCompatActivity {
    WeatherViewModel vm_weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        vm_weather = ViewModelProviders

//        binding.btRun.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(),"toast",Toast.LENGTH_LONG).show();
//                binding.tvName.setText("hello");
//            }
//        });
    }
}