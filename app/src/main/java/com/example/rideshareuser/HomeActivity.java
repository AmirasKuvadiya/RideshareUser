package com.example.rideshareuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button login;
    private Button register;
    private Button guest;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        email=findViewById(R.id.et_email);
        password=findViewById(R.id.et_password);
        login = findViewById(R.id.btn_login);
        register = findViewById(R.id.btn_register);
        auth=FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String txt_email=email.getText().toString();
                String txt_password=password.getText().toString();
                loginUser(txt_email,txt_password);
                //System.out.println("Button Clicked");
//                Intent activity2Intent = new Intent(LoginFragment.this, AdminDashboard.class);
//                startActivity(activity2Intent);
            }
        });

        guest=findViewById(R.id.btn_guest);
        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity2= new Intent(HomeActivity.this,GuestActivity.class);
                startActivity(activity2);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");
                Intent activity2Intent = new Intent(HomeActivity.this, RegisterActivity.class);
                startActivity(activity2Intent);
            }
        });

    }

    private void loginUser(String email, String password) {
        auth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(HomeActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(HomeActivity.this, UserActivity.class));
                finish();
            }
        });
    }
}