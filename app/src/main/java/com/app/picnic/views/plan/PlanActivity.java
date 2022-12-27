package com.app.picnic.views.plan;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.app.picnic.R;
import com.app.picnic.databinding.ActivityPlanBinding;
import com.app.picnic.models.model_picnic;

import java.util.List;

public class PlanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPlanBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_plan);
        PlanViewModel vm_plan =new ViewModelProvider(this).get(PlanViewModel.class);

        PlanRecycleAdapter planRecycleAdapter = new PlanRecycleAdapter();
        binding.recycler.setAdapter(planRecycleAdapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        binding.setLifecycleOwner(this);

        //-----------------------------------------------------------------------------------------
        binding.btRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Plan Activity",Toast.LENGTH_LONG).show();
//                model_picnic m = new model_picnic(binding.,1,1,"");
//                vm_plan.add_picnic();
            }
        });
        //-----------------------------------------------------------------------------------------
        vm_plan.get_picnics().observe(this, new Observer<List<model_picnic>>() {
            @Override
            public void onChanged(List<model_picnic> model_picnics) {
                planRecycleAdapter.setPicnics(model_picnics);
                Toast.makeText(getApplicationContext(),model_picnics.size()+"",Toast.LENGTH_LONG).show();
            }
        });
        //-----------------------------------------------------------------------------------------
    }
}