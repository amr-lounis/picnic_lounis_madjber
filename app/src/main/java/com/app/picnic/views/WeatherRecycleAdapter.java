package com.app.picnic.views;

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
import com.app.picnic.models.model_weather;

import java.util.ArrayList;
import java.util.List;

public class WeatherRecycleAdapter extends RecyclerView.Adapter<WeatherRecycleAdapter.RecycHeolder> {
    List<model_weather> list_model_weather = new ArrayList<>();

    @NonNull
    @Override
    public RecycHeolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecycHeolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false));
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public void onBindViewHolder(@NonNull RecycHeolder holder, int position) {
        holder.tv_name.setText(list_model_weather.get(position).getWeather());
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public int getItemCount() {
        return list_model_weather.size();
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

    public void setWeathers(List<model_weather> _weathers){
        list_model_weather = _weathers;
        notifyDataSetChanged();
    }
    public void addWeather(model_weather _weather){
        list_model_weather.add(_weather);
        notifyDataSetChanged();
    }
}
