package com.example.undarkened;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MakePlan extends AppCompatActivity {

    private DatabaseReference plandata;
    DatabaseReference reference;
    FirebaseAuth mAuth;
    FirebaseUser fuser;
    private Button btn;
    private EditText date;
    private CalendarView calendarView;
    private FusedLocationProviderClient fusedLocationClient;
    Location reallocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_plan_activity);

        plandata = FirebaseDatabase.getInstance().getReference();
        btn = (Button) findViewById(R.id.sendtodatabase);
        date = (EditText) findViewById(R.id.time);
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user = mAuth.getCurrentUser();
                String userid = user.getUid();
                DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference("Users").child(userid).child("Plan");

                HashMap<String, Object> map = new HashMap<>();

                map.put("location", reallocation.toString());

                reference1.updateChildren(map);
            }
        });
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            // Logic to handle location object
                            reallocation=location;
                        }
                    }
                });
    }

}
