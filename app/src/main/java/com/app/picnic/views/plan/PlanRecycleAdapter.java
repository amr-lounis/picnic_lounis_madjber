package com.app.picnic.views.plan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.app.picnic.R;
import com.app.picnic.models.model_picnic;
import com.app.picnic.repo.RepoPicnic;
import com.app.picnic.room.PicnicDatabase;

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
        holder.tv_id.setText(list_model_plan.get(position).getId()+"");
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
        TextView tv_id;
        ImageButton ib_delete;
        public RecycHeolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            tv_name = itemView.findViewById(R.id.card_picnic_name);
            tv_id = itemView.findViewById(R.id.card_picnic_id);
            ib_delete = itemView.findViewById(R.id.card_picnic_delete);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"Clicked to card ",Toast.LENGTH_SHORT).show();
                }
            });

            ib_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int id;
                    try {
                        Toast.makeText(context,"delete by  id "+tv_id.getText().toString(),Toast.LENGTH_SHORT).show();
                        id = Integer.parseInt(tv_id.getText().toString());
//                        PicnicDatabase.getInstance(context.getApplicationContext()).picnicDoo().deleteById(id);
                        notifyDataSetChanged();
                    }
                    catch (NumberFormatException e) {
                        id = 0;
                    }


                }
            });
        }
    }

    public void setPicnics(List<model_picnic> _picnics){
        list_model_plan = _picnics;
        notifyDataSetChanged();
    }
}
