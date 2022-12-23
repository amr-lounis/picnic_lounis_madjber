package com.app.picnic.views.plan;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.app.picnic.R;
import com.app.picnic.databinding.ActivityPlanBinding;
import com.app.picnic.models.model_picnic;

public class PlanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPlanBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_plan);
        PlanViewModel vm_plan = new ViewModelProvider(this).get(PlanViewModel.class);

        binding.setVm(vm_plan);
//        binding.setLifecycleOwner(this);
//        PlanRecycleAdapter planRecycleAdapter = new PlanRecycleAdapter();
//        binding.recycler.setAdapter(planRecycleAdapter);
//        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
//        binding.setLifecycleOwner(this);

        //-----------------------------------------------------------------------------------------
        binding.btRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Plan Activity",Toast.LENGTH_LONG).show();
            }
        });
        //-----------------------------------------------------------------------------------------
        vm_plan.model_picnicMutableLiveData.observe(this, new Observer<model_picnic>() {
            @Override
            public void onChanged(model_picnic model_picnic) {

            }
        });
        //-----------------------------------------------------------------------------------------
    }
}