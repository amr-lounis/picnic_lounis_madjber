package com.app.picnic.views.weather;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

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

public class WeatherViewModel extends ViewModel {
    public MutableLiveData<List<model_weather>> listMutableLiveData = new MutableLiveData<>();

    public void get_weathet(Context context){
        String url = "https://amr-lounis.github.io/api/data.json";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Toast.makeText(context,"responce ok",Toast.LENGTH_LONG).show();
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

                        model_weatherList.add(new model_weather(id, weather, temp, wind, visibility, snow));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listMutableLiveData.setValue(model_weatherList);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"responce error",Toast.LENGTH_LONG).show();
                Log.e("log",error.getMessage());
            }
        });
        VolleySingleton.getInstance(context).addToRequestQueue(jsonArrayRequest);
    }
}
