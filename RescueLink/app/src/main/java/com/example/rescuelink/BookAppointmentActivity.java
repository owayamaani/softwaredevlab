package com.example.rescuelink;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class BookAppointmentActivity extends AppCompatActivity {
    EditText et1,et2,et3,et4;
    TextView tv;

    private TimePickerDialog timePickerDialog;
    private DatePickerDialog datePickerDialog;
    private Button dateButton, timeButton, btnBook, btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        tv = findViewById(R.id.appTitle);
        et1 = findViewById(R.id.appName);
        et2 = findViewById(R.id.appAddress);
        et3 = findViewById(R.id.appContact);
        et4 = findViewById(R.id.appFees);
        btnBack = findViewById((R.id.backBtn2));
        btnBook = findViewById((R.id.regBtn));
        dateButton = findViewById(R.id.dateButton);
        timeButton = findViewById(R.id.timeButton);

        //ensure they are not editable
        et1.setKeyListener(null);
        et2.setKeyListener(null);
        et3.setKeyListener(null);
        et4.setKeyListener(null);

        //fetching data
        Intent it = getIntent();
        String title = it.getStringExtra("text1");
        String name = it.getStringExtra("text2");
        String address = it.getStringExtra("text3");
        String contact= it.getStringExtra("text4");
        String fees = it.getStringExtra("text5");

        //display data
        tv.setText(title);
        et1.setText(name);
        et2.setText(address);
        et3.setText(contact);
        et4.setText("consultation Fees "+fees+ " Ksh");

        //date picker
        datePickerInit();
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BookAppointmentActivity.this,FindDocActivity.class));
            }
        });

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    private void datePickerInit() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1 = i1 + 1;
                dateButton.setText(i2+"/"+i1+"/"+i);
            }
        };
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_DARK;
        datePickerDialog = new DatePickerDialog(this,style,dateSetListener,year,month,day);
        datePickerDialog.getDatePicker().setMinDate((calendar.getTimeInMillis()+86400000));

    }
    //correct later...cannot apply time picker well...
    /*private void timePickerInit() {

    }
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                //timeBtn.setText(i+":"+i1

            }
        };
        Calendar calendar = Calendar.getInstance();
        int hrs = calendar.get(Calendar.HOUR);
        int mins = calendar.get(Calendar.MINUTE);

        int style = AlertDialog.THEME_HOLO_DARK;
        timePickerDialog = new timePickerDialog(this,style,timeSetListener,hrs,mins,true);
        timePicker*/

}