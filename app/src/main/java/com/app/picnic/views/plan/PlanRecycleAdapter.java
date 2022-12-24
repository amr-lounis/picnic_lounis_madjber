package com.app.picnic.views.plan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.picnic.R;
import com.app.picnic.models.model_picnic;
import com.app.picnic.models.model_weather;

import java.util.ArrayList;
import java.util.List;

public class PlanRecycleAdapter extends RecyclerView.Adapter<PlanRecycleAdapter.RecycHeolder> {
    List<model_picnic> list_model_plan = new ArrayList<>();

    @NonNull
    @Override
    public PlanRecycleAdapter.RecycHeolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PlanRecycleAdapter.RecycHeolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_plan,parent,false));
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public void onBindViewHolder(@NonNull PlanRecycleAdapter.RecycHeolder holder, int position) {
        holder.tv_name.setText(list_model_plan.get(position).getDestination());
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public int getItemCount() {
        return list_model_plan.size();
    }

    public class RecycHeolder extends RecyclerView.ViewHolder {
        private final Context context;

        TextView tv_name;
        public RecycHeolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            tv_name = itemView.findViewById(R.id.name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"Clicked to card ",Toast.LENGTH_SHORT).show();
                }
            });
//            Button b = itemView.findViewById(R.id.go);
//            b.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent i = new Intent(context, PlanEditActivity.class);
//                    context.startActivity(i);
//                }
//            });
        }
    }

    public void setPicnics(List<model_picnic> _picnics){
        list_model_plan = _picnics;
        notifyDataSetChanged();
    }
    public void addPicnic(model_picnic _picnic){
        list_model_plan.add(_picnic);
        notifyDataSetChanged();
    }
}
