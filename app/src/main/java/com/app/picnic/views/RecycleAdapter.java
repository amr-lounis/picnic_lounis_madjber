package com.app.picnic.views;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.picnic.MainActivity;
import com.app.picnic.R;
import com.app.picnic.models.model_weather;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.RecycHeolder> {
    public ArrayList<model_weather> weathers = new ArrayList<>();
    @NonNull
    @Override
    public RecycHeolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecycHeolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecycHeolder holder, int position) {
        holder.tv_name.setText(weathers.get(position).getWeather());
    }

    @Override
    public int getItemCount() {
        return weathers.size();
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
            Button b = itemView.findViewById(R.id.go);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, PlanActivity.class);
                    context.startActivity(i);
                }
            });
        }
    }

    public void addWeather(model_weather _weather){
        this.weathers.add(_weather);
        notifyDataSetChanged();
    }
}
