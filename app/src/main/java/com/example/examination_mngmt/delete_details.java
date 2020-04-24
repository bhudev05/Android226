package com.example.examination_mngmt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class delete_details extends AppCompatActivity {

    EditText etdel;
    Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_details);

        etdel = findViewById(R.id.etdel);
        delete =findViewById(R.id.delete);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ExamDatabase ed = new ExamDatabase(getApplication());
                ed.doDelete(etdel.getText().toString());
                finish();
            }
        });
    }
}
