package com.app.picnic.views.plan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;

import com.app.picnic.R;
import com.app.picnic.databinding.ActivityPlanEditBinding;

import java.util.Calendar;

public class PlanEditActivity extends AppCompatActivity {

    int hour;
    int minute;
    ActivityPlanEditBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_plan_edit);
        PlanViewModel planViewModel = new ViewModelProvider(this).get(PlanViewModel.class);

        Calendar calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);
//        binding.time.setText(HOUR+":"+MINUTE);
        binding.time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog();
            }
        });
    }
    private void dialog(){
        TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener(){
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                binding.time.setText(hour+":"+minute);
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,listener,hour,minute,false);
        timePickerDialog.show();
    }
}