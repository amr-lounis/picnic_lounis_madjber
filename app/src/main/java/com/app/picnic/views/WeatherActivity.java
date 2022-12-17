package com.app.picnic.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.app.picnic.R;
import com.app.picnic.databinding.ActivityWeatherBinding;
import com.app.picnic.utils.VolleySingleton;
import com.app.picnic.viewmodels.WeatherViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        ActivityWeatherBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_weather);

        WeatherViewModel vm_weather = new ViewModelProvider(this).get(WeatherViewModel.class);
        binding.setVm(vm_weather);
        binding.setLifecycleOwner(this);

        RecycleAdapter recycleAdapter = new RecycleAdapter();
        binding.recycler.setAdapter(recycleAdapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        binding.setLifecycleOwner(this);

        String API_key = "ab789c825b2ef1f91044bb0897022b93";
        String lat = "36";
        String lon = "3";
        String exclude = "daily";


//                                https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid=ab789c825b2ef1f91044bb0897022b93
//        String url = "https://api.openweathermap.org/data/2.5/onecall?lat="+lat+"&lon="+lon+"&exclude="+exclude+"&appid="+API_key+"";
//        String url = "https://pro.openweathermap.org/data/2.5/forecast/hourly?lat={lat}&lon={lon}&appid={}";
        String url = String.format("https://pro.openweathermap.org/data/2.5/forecast/hourly?lat=%s&lon=%s&appid=%s", lat,lon,API_key);
        Log.e("APII",url);

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET,url,null,
                new Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String cod = response.getString("cod");
                    if(cod == "200"){

                    }
                    Toast.makeText(getApplicationContext(),cod,Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
                }
            }
        },
                new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        VolleySingleton.getInstance(this).addToRequestQueue(jor);

//        for(int i = 0;i<10;i++){
//            recycleAdapter.addWeather(new model_weather("aaaa","00"+i,"xxxx","xxxxx","xxxx"));
//        }

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