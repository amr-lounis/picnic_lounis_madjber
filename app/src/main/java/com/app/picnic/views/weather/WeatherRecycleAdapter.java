package com.app.picnic.views.weather;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.app.picnic.R;
import com.app.picnic.models.model_weather;
import com.app.picnic.views.plan.PlanActivity;
import com.app.picnic.views.plan.PlanEditActivity;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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
        holder.tv_weather.setText(list_model_weather.get(position).getWeather());
        holder.tv_temp.setText("temp : "+list_model_weather.get(position).getTemp()+"°");
        holder.tv_id.setText("day : "+list_model_weather.get(position).getId()+"°");

        Picasso.get().
                load(list_model_weather.get(position).getIcon()).
                into(holder.iv_image);
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
