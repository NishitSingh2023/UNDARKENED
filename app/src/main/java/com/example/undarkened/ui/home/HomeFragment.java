package com.example.undarkened.ui.home;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.undarkened.Adapter.PlanAdapter;
import com.example.undarkened.MakePlan;
import com.example.undarkened.Model.Plan;
import com.example.undarkened.R;
import com.example.undarkened.Search;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    Button makePlan;
    Button search;
    View v;
    DatabaseReference reference;
    RecyclerView recyclerView;
    List<Plan> planlist;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_home, container, false);
        final ProgressDialog pd = new ProgressDialog(v.getContext());
        pd.show();

        makePlan = (Button)v.findViewById(R.id.button_plan);
        recyclerView=(RecyclerView)v.findViewById(R.id.db_list);
        makePlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
        planlist=new ArrayList<>();
        reference = FirebaseDatabase.getInstance().getReference("plan");

        search = (Button) v.findViewById(R.id.searchbtn);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openvideocall();
            }
        });

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Plan templist = snapshot.getValue(Plan.class);
                    planlist.add(templist);
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
                recyclerView.setAdapter(new PlanAdapter(getContext().getApplicationContext(),planlist));
                pd.dismiss();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        return v;
    }
    public void openActivity(){
        Intent intent = new Intent(v.getContext(), MakePlan.class);
        startActivity(intent);
    }
    public void openvideocall(){
        Intent i = new Intent(v.getContext(), Search.class);
        startActivity(i);

    }
}