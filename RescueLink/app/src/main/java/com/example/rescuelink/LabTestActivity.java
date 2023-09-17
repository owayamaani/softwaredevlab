package com.example.rescuelink;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class LabTestActivity extends AppCompatActivity {

    private String[][] packages = {
            {"Package 1: Full Body Checkup", "", "","", "1500"},
            {"Package 2: Blood test", "", "","", "1500"},
            {"Package 3: Immunity Test", "", "","", "500"},

    };
    private String[] package_details ={
            "Blood Glucose\n"+
                    "Sonogram\n"+
                    "Haemoglobin\n"+
                    "Liver function\n"+
                    "Kidney function",
            "Blood Test",
            "Immunity\n"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);
    }
}