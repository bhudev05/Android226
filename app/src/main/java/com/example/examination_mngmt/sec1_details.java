package com.example.examination_mngmt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sec1_details extends AppCompatActivity {

    Button add,view,update,delete,search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec1_details);
        add=findViewById(R.id.ad);
        view=findViewById(R.id.view);
        update=findViewById(R.id.update);
        delete=findViewById(R.id.delete);
        search =findViewById(R.id.search);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1= new Intent(sec1_details.this,add_details.class);
                startActivity(i1);

            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i2= new Intent(sec1_details.this,view_details.class);
            startActivity(i2);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(sec1_details.this,update_details.class);
                startActivity(i3);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(sec1_details.this,delete_details.class);
                startActivity(i4);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5 = new Intent(sec1_details.this,search_details.class);
                startActivity(i5);
            }
        });




    }
}
