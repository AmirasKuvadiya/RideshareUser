package com.example.rideshareuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class UserActivity extends AppCompatActivity {

    private Button logout;
    private Button book_ride;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        logout=findViewById(R.id.btn_logout);
        book_ride=findViewById(R.id.btn_book_ride);

        book_ride.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserActivity.this,BookActivity.class));
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(UserActivity.this,"Logged Out",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(UserActivity.this,HomeActivity.class));
            }
        });

    }
}