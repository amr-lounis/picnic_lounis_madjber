package com.app.picnic.viewmodels;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WeatherViewModel extends ViewModel {
//    LiveData<String> lds_name = new LiveData<>() ;
    public MutableLiveData<String>  mlds_name = new MutableLiveData<>() ;

    public void get_name(){
        mlds_name.setValue("jjjjjjjjjjjjjjjjjjjjjjjjjjj");
    }

}
