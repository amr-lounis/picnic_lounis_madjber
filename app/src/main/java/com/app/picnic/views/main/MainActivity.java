package com.app.picnic.views.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.app.picnic.R;
import com.app.picnic.databinding.ActivityMainBinding;
import com.app.picnic.models.model_picnic;
import com.app.picnic.repo.RepoPicnic;
import com.app.picnic.room.PicnicDatabase;
import com.app.picnic.views.plan.PlanActivity;
import com.app.picnic.views.weather.WeatherActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.btRunWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent i = new Intent(getBaseContext(), WeatherActivity.class);
                    startActivity(i);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
                }
            }
        });

        binding.btRunPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent i = new Intent(getApplicationContext(), PlanActivity.class);
                    startActivity(i);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    void runn(){
        String backupDBPath = PicnicDatabase.getInstance(getApplicationContext()).getOpenHelper().getWritableDatabase().getPath();
        Toast.makeText(getApplicationContext(),backupDBPath,Toast.LENGTH_LONG).show();
    }
}