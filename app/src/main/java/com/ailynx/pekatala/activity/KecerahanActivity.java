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

public class KecerahanActivity extends AppCompatActivity {
    CoordinatorLayout activity_kecerahan;
    RadioButton radio_kecerahan_1, radio_kecerahan_2, radio_kecerahan_3;
    ImageView info_kecerahan;
    Integer kecerahan = 0;
    FloatingActionButton fab_kecerahan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kecerahan);

        getSupportActionBar().setTitle("Kecerahan");
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        activity_kecerahan = (CoordinatorLayout) findViewById(R.id.activity_kecerahan);
        radio_kecerahan_1 = (RadioButton) findViewById(R.id.radio_kecerahan_1);
        radio_kecerahan_2 = (RadioButton) findViewById(R.id.radio_kecerahan_2);
        radio_kecerahan_3 = (RadioButton) findViewById(R.id.radio_kecerahan_3);
        info_kecerahan = (ImageView) findViewById(R.id.info_kecerahan);
        fab_kecerahan = (FloatingActionButton) findViewById(R.id.fab_kecerahan);

        radio_kecerahan_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    kecerahan = 1;
                }
            }
        });
        radio_kecerahan_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    kecerahan = 2;
                }
            }
        });
        radio_kecerahan_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    kecerahan = 3;
                }
            }
        });

        fab_kecerahan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kecerahan == 0) {
                    Snackbar.make(activity_kecerahan, "Pilih kecerahan.", Snackbar.LENGTH_SHORT).show();
                } else {
                    UserData.transaksi.setKecerahan(kecerahan);
                    Intent intent = new Intent(KecerahanActivity.this, SuhuActivity.class);
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
