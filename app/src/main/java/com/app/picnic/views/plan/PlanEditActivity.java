package com.app.picnic.views.plan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.app.picnic.R;
import com.app.picnic.databinding.ActivityPlanEditBinding;

public class PlanEditActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPlanEditBinding activityPlanEditBinding = DataBindingUtil.setContentView(this,R.layout.activity_plan_edit);
        PlanViewModel planViewModel = new ViewModelProvider(this).get(PlanViewModel.class);


    }
}