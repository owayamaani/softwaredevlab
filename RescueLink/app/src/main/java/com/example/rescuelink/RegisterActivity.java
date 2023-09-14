package com.example.rescuelink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText edUsername, edEmail, edPassword, edConfirm;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUsername = findViewById(R.id.appName);
        edEmail = findViewById(R.id.appAddress);
        edPassword  = findViewById(R.id.appContact);
        edConfirm = findViewById(R.id.appFees);
        btn = findViewById(R.id.bookBtn) ;
        tv = findViewById(R.id.textViewExisting);



        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,loginActivity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String confirm = edConfirm.getText().toString();
                database db = new database(getApplicationContext(),"medical",null,1);

                if(username.length()==0 || password.length()==0 || email.length()==0 || confirm.length()==0){
                    Toast.makeText(getApplicationContext(), "Fill all required fields.", Toast.LENGTH_SHORT).show();
                }else{
                    if(password.compareTo(confirm)==0) {
                        if(isValid(password)){
                            db.register(username, email,password);
                            Toast.makeText(getApplicationContext(), "Record  saved.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, loginActivity.class)) ;
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Password must contain at least 8 characters, a letter, digit and a special symbol", Toast.LENGTH_SHORT).show();
                        }
                    }
                        else{
                            Toast.makeText(getApplicationContext(), "passwords do not match", Toast.LENGTH_SHORT).show();
                        }


                }
            }
        });

    }
    public static boolean isValid(String passwordcheck) {
        int f1 = 0, f2 = 0, f3 = 0;
        if(passwordcheck.length() < 8) {
            return false;
        } else {
            for (int p = 0; p < passwordcheck.length(); p++) {
                if (Character.isLetter(passwordcheck.charAt(p))) {
                    f1 = 1;
                }
            }
            for (int r = 0; r < passwordcheck.length(); r++) {
                if (Character.isDigit(passwordcheck.charAt(r))) {
                    f2 = 1;
                }
            }
            for (int s = 0; s < passwordcheck.length(); s++) {
                char c = passwordcheck.charAt(s);
                if (c>=33&c<=46 || c==64) {
                    f3 = 1;
                }
            }
            if(f1==1 && f2==1 && f3==1)
                return true;
            return false;
        }
    }
}