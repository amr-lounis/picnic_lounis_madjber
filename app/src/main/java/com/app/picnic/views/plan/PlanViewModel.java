package com.app.picnic.views.plan;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.app.picnic.models.model_picnic;
import com.app.picnic.repo.RepoPicnic;

import java.util.List;

public class PlanViewModel extends AndroidViewModel {
    private RepoPicnic repoPicnic;

    public PlanViewModel(@NonNull Application application) {
        super(application);
        repoPicnic = new RepoPicnic(application);
    }

    public LiveData<List<model_picnic>> get_picnics(){
        return repoPicnic.get();
    }

    public void add_picnic(model_picnic m){
        repoPicnic.insertAsync(m);
    }


}
