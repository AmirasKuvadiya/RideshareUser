package com.example.rideshareuser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private EditText password;
    private EditText repassword;
    private Button register;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name=findViewById(R.id.et_name);
        email=findViewById(R.id.et_email);
        password=findViewById(R.id.et_password);
        repassword=findViewById(R.id.et_repassword);
        register=findViewById(R.id.btn_register);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_name=name.getText().toString();
                String txt_email=email.getText().toString();
                String txt_pass=password.getText().toString();
                String txt_repassword=repassword.getText().toString();

                if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_pass)){
                    Toast.makeText(getApplicationContext(),  "Empty credentials", Toast.LENGTH_SHORT).show();
                } else if(txt_pass.length()<6){
                    Toast.makeText(getApplicationContext(),  "Password too short", Toast.LENGTH_SHORT).show();
                } else if(!(txt_pass.equals(txt_repassword))){
                    Toast.makeText(getApplicationContext(),"Password does not match",Toast.LENGTH_SHORT).show();
                }
                else {
                    registerUser(txt_email,txt_pass);
                }
            }
        });
    }

    private void registerUser(String txt_email, String txt_pass) {
        auth.createUserWithEmailAndPassword(txt_email,txt_pass).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Registration is successful",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this,HomeActivity.class));
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Registration Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}