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

public class PencemarActivity extends AppCompatActivity {
    CoordinatorLayout activity_pencemar;
    RadioButton radio_pencemar_3, radio_pencemar_2, radio_pencemar_1;
    ImageView info_pencemar;
    Integer pencemar = 0;
    FloatingActionButton fab_pencemar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencemar);

        getSupportActionBar().setTitle("Pencemar");
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        activity_pencemar = (CoordinatorLayout) findViewById(R.id.activity_pencemar);
        radio_pencemar_1 = (RadioButton) findViewById(R.id.radio_pencemar_1);
        radio_pencemar_2 = (RadioButton) findViewById(R.id.radio_pencemar_2);
        radio_pencemar_3 = (RadioButton) findViewById(R.id.radio_pencemar_3);
        info_pencemar = (ImageView) findViewById(R.id.info_pencemar);
        fab_pencemar = (FloatingActionButton) findViewById(R.id.fab_pencemar);

        radio_pencemar_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    pencemar = 1;
                }
            }
        });
        radio_pencemar_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    pencemar = 2;
                }
            }
        });
        radio_pencemar_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    pencemar = 3;
                }
            }
        });
        fab_pencemar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pencemar == 0) {
                    Snackbar.make(activity_pencemar, "Pilih pencemar.", Snackbar.LENGTH_SHORT).show();
                } else {
                    UserData.transaksi.setPencemar(pencemar);
                    Intent intent = new Intent(PencemarActivity.this, HamaPenyakitActivity.class);
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
