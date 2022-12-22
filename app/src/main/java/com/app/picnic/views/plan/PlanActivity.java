package com.app.picnic.views.plan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.Toast;

import com.app.picnic.R;
import com.app.picnic.databinding.ActivityPlanBinding;

public class PlanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        Toast.makeText(getApplicationContext(),"Clicked to card ",Toast.LENGTH_SHORT).show();

        ActivityPlanBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_plan);
        binding.tvOutput.setText("hhhhhhhhhhhh");
    }
}