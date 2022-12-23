package com.app.picnic.views.plan;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.app.picnic.models.model_picnic;

public class PlanViewModel extends ViewModel {
    public MutableLiveData<model_picnic> model_picnicMutableLiveData = new MutableLiveData<>();
}
