package com.ailynx.pekatala.dialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.ailynx.pekatala.activity.LoginActivity;
import com.ailynx.pekatala.R;

public class DateDialog extends AppCompatActivity {
    DatePicker date_picker;
    Button btn_date_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_date);

        date_picker = (DatePicker) findViewById(R.id.date_picker);
        btn_date_ok = (Button) findViewById(R.id.btn_date_ok);

        btn_date_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.dateString = date_picker.getYear() + "-" + (date_picker.getMonth() + 1) + "-" + date_picker.getDayOfMonth();
                finish();
            }
        });
    }
}
