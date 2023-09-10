package com.example.rescuelink;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class FindDocActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doc);

        CardView back = findViewById(R.id.backCard);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(FindDocActivity.this,HomeActivity.class));
            }
        });

        CardView generalDoctor = findViewById(R.id.famDoc);
        generalDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDocActivity.this,DocDetailsActivity.class);
                it.putExtra("title","General Doctor");
                startActivity(it);
            }
        });

        CardView dietician = findViewById(R.id.dietCard);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDocActivity.this, DocDetailsActivity.class);
                it.putExtra("title", "Dietician");
                startActivity(it);
            }
        });

        CardView dentist = findViewById(R.id.dentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDocActivity.this, DocDetailsActivity.class);
                it.putExtra("title", "Dentist");
                startActivity(it);
            }
        });


    }
}