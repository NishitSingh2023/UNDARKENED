package com.example.undarkened.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.undarkened.MakePlan;
import com.example.undarkened.R;

public class HomeFragment extends Fragment {
Button makePlan;
    View v;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_home, container, false);

        makePlan = (Button)v.findViewById(R.id.button_plan);
        makePlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
        return v;
    }
    public void openActivity(){
        Intent intent = new Intent(v.getContext(), MakePlan.class);
        startActivity(intent);
    }
}