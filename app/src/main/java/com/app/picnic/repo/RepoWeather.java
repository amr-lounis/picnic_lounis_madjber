package com.app.picnic.repo;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.app.picnic.models.model_weather;
import com.app.picnic.utils.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RepoWeather {
    String url = "https://amr-lounis.github.io/api/data.json";
    Application application ;
    VolleySingleton instance ;
    public  MutableLiveData<List<model_weather>> mld_weathers =new MutableLiveData<>() ;

    public MutableLiveData<List<model_weather>> get_weathers() {
        return this.mld_weathers;
    }

    public RepoWeather(Application application){
        this.application = application;
        this.instance = VolleySingleton.getInstance(application);
    }

    public void Request(){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, this.url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Toast.makeText(application,"responce ok",Toast.LENGTH_LONG).show();
                List<model_weather> model_weatherList = new ArrayList<>();
                try {
                    for(int i = 0;i< response.length();i++) {
                        JSONObject jsonObject = response.getJSONObject(i);
                        int id = jsonObject.getInt("id");
                        String weather = jsonObject.getString("weather");
                        Double temp = jsonObject.getDouble("temp");
                        Double wind = jsonObject.getDouble("wind");
                        Double visibility = jsonObject.getDouble("visibility");
                        Double snow = jsonObject.getDouble("snow");

                        model_weatherList.add(new model_weather(id, weather, temp));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                mld_weathers.setValue(model_weatherList);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(application,"responce error",Toast.LENGTH_LONG).show();
                Log.e("log",error.getMessage());
            }
        });
        this.instance.addToRequestQueue(jsonArrayRequest);
    }
}
