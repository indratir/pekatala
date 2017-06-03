package com.ailynx.pekatala.activity;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.ailynx.pekatala.R;
import com.ailynx.pekatala.data.UserData;

public class SalinitasActivity extends AppCompatActivity {
    CoordinatorLayout activity_salinitas;
    RadioButton radio_salinitas_1, radio_salinitas_2, radio_salinitas_3;
    ImageView info_salinitas;
    Integer salinitas = 0;
    FloatingActionButton fab_salinitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salinitas);

        getSupportActionBar().setTitle("Salinitas");
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        activity_salinitas = (CoordinatorLayout) findViewById(R.id.activity_salinitas);
        radio_salinitas_1 = (RadioButton) findViewById(R.id.radio_salinitas_1);
        radio_salinitas_2 = (RadioButton) findViewById(R.id.radio_salinitas_2);
        radio_salinitas_3 = (RadioButton) findViewById(R.id.radio_salinitas_3);
        info_salinitas = (ImageView) findViewById(R.id.info_salinitas);
        fab_salinitas = (FloatingActionButton) findViewById(R.id.fab_salinitas);

        radio_salinitas_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    salinitas = 1;
                }
            }
        });
        radio_salinitas_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    salinitas = 2;
                }
            }
        });
        radio_salinitas_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    salinitas = 3;
                }
            }
        });

        fab_salinitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (salinitas == 0) {
                    Snackbar.make(activity_salinitas, "Pilih salinitas.", Snackbar.LENGTH_SHORT).show();
                } else {
                    UserData.transaksi.setSalinitas(salinitas);
                    Intent intent = new Intent(SalinitasActivity.this, KecerahanActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
