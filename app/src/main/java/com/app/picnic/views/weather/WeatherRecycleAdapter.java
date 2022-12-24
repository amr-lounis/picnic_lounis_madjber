package com.app.picnic.views.weather;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.app.picnic.R;
import com.app.picnic.models.model_weather;
import com.app.picnic.views.plan.PlanEditActivity;
import java.util.ArrayList;
import java.util.List;

public class WeatherRecycleAdapter extends RecyclerView.Adapter<WeatherRecycleAdapter.RecycHeolder> {
    List<model_weather> list_model_weather = new ArrayList<>();

    @NonNull
    @Override
    public RecycHeolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecycHeolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_weather,parent,false));
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public void onBindViewHolder(@NonNull RecycHeolder holder, int position) {
        String weather = list_model_weather.get(position).getWeather();
        String temp = "temp : "+list_model_weather.get(position).getTemp()+"°";
        String day = "day : "+list_model_weather.get(position).getId()+"°";

        holder.tv_weather.setText(weather);
        holder.tv_temp.setText(temp);
        holder.tv_id.setText(day);

        int src =  R.drawable.sun;
        if(weather.equals("sun"))src = R.drawable.sun;
        if(weather.equals("cloud_sun"))src = R.drawable.cloud_sun;
        if(weather.equals("rain"))src = R.drawable.rain;
        if(weather.equals("snowing"))src = R.drawable.snowing;
        holder.iv_image.setImageResource(src);
    }
    //---------------------------------------------------------------------------------------------
    @Override
    public int getItemCount() {
        return list_model_weather.size();
    }

    public class RecycHeolder extends RecyclerView.ViewHolder {
        private final Context context;

        ImageView iv_image;
        TextView tv_id;
        TextView tv_weather;
        TextView tv_temp;

        public RecycHeolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();

            iv_image = itemView.findViewById(R.id.card_iv_weather);

            tv_id = itemView.findViewById(R.id.card_tv_id);
            tv_weather= itemView.findViewById(R.id.card_tv_weather);
            tv_temp = itemView.findViewById(R.id.card_tv_temp);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"Clicked to card ",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(context, PlanEditActivity.class);
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
