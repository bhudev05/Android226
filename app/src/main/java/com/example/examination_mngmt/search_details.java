package com.example.examination_mngmt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class search_details extends AppCompatActivity {

    EditText et;
    ListView lv;
    ExamDatabase ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_details);

        et =findViewById(R.id.search);
        lv=findViewById(R.id.listView);

        ed= new ExamDatabase(getApplicationContext());

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ArrayList<String> al = ed.doSearch(s.toString());
                ArrayAdapter ad = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,al);

                lv.setAdapter(ad);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
}
