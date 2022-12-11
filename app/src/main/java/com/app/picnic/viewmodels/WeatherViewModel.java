package com.app.picnic.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WeatherViewModel extends ViewModel {
//    LiveData<String> lds_name = new LiveData<>() ;
    MutableLiveData<String>  mlds_name = new MutableLiveData<>() ;

    void get_name(){
        mlds_name.setValue("jjjjjjjjjjjjjjjjjjjjjjjjjjj");
    }

}
