package com.app.picnic.views.plan;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.app.picnic.models.model_picnic;

import java.util.List;

public class PlanViewModel extends ViewModel {
    private MutableLiveData<List<model_picnic>> mld_picnics = new MutableLiveData<>();

    public MutableLiveData<List<model_picnic>> get_picnics() {
        return mld_picnics;
    }

    public void set_picnics(List<model_picnic> _picnics) {
        this.mld_picnics.setValue( _picnics);
    }
}
