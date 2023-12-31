package com.example.rescuelink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DocDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details = {
            {"Doctor Name: Dianah Njenga", "Hospital Address : Guru Nanak", "Mobile N0:0712345678", "500"},
            {"Doctor Name: Brian Omondi", "Hospital Address : MpShah", "Mobile N0:0712345678", "1000"},
            {"Doctor Name: Rachael Ngatha", "Hospital Address : Guru Nanak", "Mobile N0:0712345678", "500"},
            {"Doctor Name: Queen Wangari", "Hospital Address : Kenyatta Hospital", "Mobile N0:0712345678", "600"},
            {"Doctor Name: Jackson Brian", "Hospital Address : Equity Afia", "Mobile N0:0712345678", "500"}
    };

    private String[][] doctor_details2 = {
            {"Doctor Name: Dianah Obat", "Hospital Address : Guru Nanak", "Mobile N0:0712345678", "1500"},
            {"Doctor Name: Samuel Omondi", "Hospital Address : MpShah", "Mobile N0:0712345678", "1000"},
            {"Doctor Name: Edgar Sirancha", "Hospital Address : Guru Nanak", "Mobile N0:0712345678", "1500"},
            {"Doctor Name: Milton Karanja", "Hospital Address : Kenyatta Hospital", "Mobile N0:0712345678", "1000"},
            {"Doctor Name: Felix Onyango", "Hospital Address : Equity Afia", "Mobile N0:0712345678", "1500"}
    };
    private String[][] doctor_details3 = {
            {"Doctor Name: Rose Mary", "Hospital Address : Guru Nanak", "Mobile N0:0712345678", "1500"},
            {"Doctor Name: Joseph Nganga", "Hospital Address : MpShah", "Mobile N0:0712345678", "1000"},
            {"Doctor Name: Ivy Njeri", "Hospital Address : Guru Nanak", "Mobile N0:0712345678", "1500"},
            {"Doctor Name: Marcus Jacob", "Hospital Address : Kenyatta Hospital", "Mobile N0:0712345678", "2500"},
            {"Doctor Name: Janira Claire", "Hospital Address : Equity Afia", "Mobile N0:0712345678", "2500"}
    };
    private String[][] doctor_details4= {
            {"Doctor Name: Victor Parmuat", "Hospital Address : Guru Nanak", "Mobile N0:0712345678", "5500"},
            {"Doctor Name: Taiyo Ole Kaelo", "Hospital Address : MpShah", "Mobile N0:0712345678", "5000"},
            {"Doctor Name: Joseph Kamari", "Hospital Address : Guru Nanak", "Mobile N0:0712345678", "5500"},
            {"Doctor Name: Ruth Adengoi", "Hospital Address : Kenyatta Hospital", "Mobile N0:0712345678", "6600"},
            {"Doctor Name: Dylan Brian", "Hospital Address : Equity Afia", "Mobile N0:0712345678", "7500"}
    };
    private String[][] doctor_details5 = {
            {"Doctor Name: Dianah Njenga", "Hospital Address : Guru Nanak", "Mobile N0:0712345678", "2500"},
            {"Doctor Name: Brian Omondi", "Hospital Address : MpShah", "Mobile N0:0712345678", "1000"},
            {"Doctor Name: Rachael Ngatha", "Hospital Address : Guru Nanak", "Mobile N0:0712345678", "2500"},
            {"Doctor Name: Queen Wangari", "Hospital Address : Kenyatta Hospital", "Mobile N0:0712345678", "2600"},
            {"Doctor Name: Jackson Brian", "Hospital Address : Equity Afia", "Mobile N0:0712345678", "1500"}
    };
    TextView tv;
    Button btn;
    String[][] doc_details= {};
    ArrayList list;
    HashMap<String,String > item;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_details);

        tv = findViewById((R.id.mediView2));
        btn = findViewById(R.id.LtBackBtn);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("General Doctor")==0)
            doc_details=doctor_details;
        else if (title.compareTo("Dietitian")==0)
            doc_details = doctor_details2;
        else if (title.compareTo("Dentist")==0)
            doc_details = doctor_details3;
        else if (title.compareTo("Surgeon")==0)
            doc_details = doctor_details4;
        else
            doc_details = doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DocDetailsActivity.this,FindDocActivity.class));

            }
        });

        list = new ArrayList();
        for (int i=0;i<doc_details.length;i++){
            item = new HashMap<String, String>();
            item.put("line1",doc_details[i][0]);
            item.put("line2",doc_details[i][1]);
            item.put("line3",doc_details[i][2]);
            item.put("line4","Consultation fee:"+doc_details[i][2]+"Ksh");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multiline,
                new String[]{"line1","line2","line3","line4",},
                new int []{R.id.line_1,R.id.line_2,R.id.line_3,R.id.line_3b});
        ListView lst = findViewById(R.id.labListView);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DocDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doc_details[i][0]);
                it.putExtra("text3",doc_details[i][1]);
                it.putExtra("text4",doc_details[i][2]);
                it.putExtra("text5",doc_details[i][3]);

                startActivity(it);
            }
        });

    }
}