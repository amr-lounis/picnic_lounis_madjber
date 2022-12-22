package com.app.picnic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.app.picnic.databinding.ActivityMainBinding;
import com.app.picnic.views.WeatherActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.btRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent i = new Intent(getApplicationContext(), WeatherActivity.class);
                    startActivity(i);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}