package com.app.picnic.views.weather;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.app.picnic.models.model_weather;
import com.app.picnic.repo.RepoWeather;

import java.util.ArrayList;
import java.util.List;

public class WeatherViewModel extends AndroidViewModel {
    RepoWeather repoWeather ;
    MutableLiveData<List<model_weather>> mld_weather ;

    public WeatherViewModel(@NonNull Application application)
    {
        super(application);
        repoWeather = new RepoWeather(application);
        mld_weather = repoWeather.get_weathers();
    }

    public MutableLiveData<List<model_weather>> get_weathet(){
        return  repoWeather.get_weathers();
    }

    public void request(){
        repoWeather.Request();
    }
    public void clear(){
        repoWeather.get_weathers().setValue(new ArrayList<model_weather>());
    }
}
