package com.example.examination_mngmt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class update_details extends AppCompatActivity {

    EditText name,reg,room,sub,dt;
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_details);

        name = findViewById(R.id.name);
        reg =findViewById(R.id.reg);
        room =findViewById(R.id.room);
        sub= findViewById(R.id.sub);
        dt= findViewById(R.id.date);

        update =findViewById(R.id.update);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExamDatabase ed = new ExamDatabase(getApplicationContext());
                ed.doUpdate(name.getText().toString(),Long.parseLong(reg.getText().toString()),room.getText().toString(),sub.getText().toString(),dt.getText().toString());

                finish();
            }
        });
    }
}
