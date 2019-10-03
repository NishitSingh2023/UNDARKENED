package com.example.undarkened.Adapter;

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

import com.example.undarkened.Model.Plan;
import com.example.undarkened.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.ViewHolder> {
    List<Plan> bal;
    PlanAdapter.ItemClicked activity;

    FirebaseUser firebaseUser;
    DatabaseReference reference;

    public interface  ItemClicked {
    }

    public PlanAdapter (Context context, List<Plan> list) {
        bal=list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView plan_date,plan_time,plan_lat,plan_lon;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            plan_date=itemView.findViewById(R.id.plan_date);
            plan_time=itemView.findViewById(R.id.plan_time);
            plan_lat=itemView.findViewById(R.id.plan_lat);
            plan_lon=itemView.findViewById(R.id.plan_lon);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   // Intent intent=new Intent(activity,List);
                }
            });
        }
    }


    // Method to  create our own view holder
    @NonNull
    @Override
    public PlanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.plancardview,viewGroup,false);
        return new PlanAdapter.ViewHolder(view);
    }

    // Method to create view holder data
    @Override
    public void onBindViewHolder(@NonNull final PlanAdapter.ViewHolder viewHolder, int i) {

        viewHolder.plan_date.setText("Date :"+bal.get(i).getDate());
        viewHolder.plan_time.setText("Time :"+bal.get(i).getTime());
        viewHolder.plan_lat.setText("Latitude :"+bal.get(i).getLatitude());
        viewHolder.plan_lon.setText("Longitude :"+bal.get(i).getLongitude());
    }

    //Method to get count od object of person in an array
    @Override
    public int getItemCount() {
        return bal.size();
    }
}
