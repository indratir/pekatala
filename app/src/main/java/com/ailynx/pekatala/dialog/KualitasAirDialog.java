package com.ailynx.pekatala.dialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ailynx.pekatala.R;

public class KualitasAirDialog extends AppCompatActivity {
    TextView title_kualitas_air, text_kualitas_air;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_kualitas_air);

        id = getIntent().getIntExtra("id", 0);
        title_kualitas_air = (TextView) findViewById(R.id.title_kualitas_air);
        text_kualitas_air = (TextView) findViewById(R.id.text_kualitas_air);

        if (id == R.id.info_salinitas){
            title_kualitas_air.setText("Salinitas");
        } else if (id == R.id.info_kecerahan){
            title_kualitas_air.setText("Kecerahan");
        } else if (id == R.id.info_suhu){
            title_kualitas_air.setText("Suhu");
        } else if (id == R.id.info_kedalaman){
            title_kualitas_air.setText("Kedalaman");
        } else if (id == R.id.info_kecepatanarus){
            title_kualitas_air.setText("Kecepatan arus");
        } else if (id == R.id.info_substratdasarpantai){
            title_kualitas_air.setText("Substrat dasar pantai");
        } else if (id == R.id.info_keterlindungan){
            title_kualitas_air.setText("Keterlindungan");
        } else if (id == R.id.info_keterjangkauan){
            title_kualitas_air.setText("Keterjangkauan");
        } else if (id == R.id.info_pencemar){
            title_kualitas_air.setText("Pencemar");
        }
    }
}
