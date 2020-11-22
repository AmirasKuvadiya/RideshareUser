package com.example.rideshareuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GuestActivity extends AppCompatActivity {

    Button guest_login;
    Button book_ride;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);

        guest_login=findViewById(R.id.btn_guest_login);

        guest_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuestActivity.this,UserActivity.class));
                Toast.makeText(GuestActivity.this,"Logged in",Toast.LENGTH_SHORT).show();
            }
        });


    }

}