package com.app.picnic.views.plan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.app.picnic.R;
import com.app.picnic.databinding.ActivityPlanEditBinding;

public class PlanEditActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_edit);
        ActivityPlanEditBinding activityPlanEditBinding = DataBindingUtil.setContentView(this,R.layout.activity_plan_edit);
    }
}