package com.example.examination_mngmt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class add_details extends AppCompatActivity {
    EditText name,reg,room,sub,dt;
    Button B;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_details);

        name=findViewById(R.id.name);
        reg=findViewById(R.id.reg);
        room=findViewById(R.id.room);
        sub=findViewById(R.id.subject);
        dt=findViewById(R.id.date);

        B=findViewById(R.id.save);

        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            ExamDatabase ed = new ExamDatabase(getApplicationContext());
            ed.insertValues(name.getText().toString(),Long.parseLong(reg.getText().toString()),room.getText().toString(),sub.getText().toString(),dt.getText().toString());

            finish();
            }
        });
    }
}
