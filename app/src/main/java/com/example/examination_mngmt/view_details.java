package com.example.examination_mngmt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class view_details extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);
        listView =findViewById(R.id.lv);

        ExamDatabase ed = new ExamDatabase(getApplicationContext());
        ArrayList<String> al = ed.showValues();

        ArrayAdapter<String > ad = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,al);
        listView.setAdapter(ad);

    }
}
