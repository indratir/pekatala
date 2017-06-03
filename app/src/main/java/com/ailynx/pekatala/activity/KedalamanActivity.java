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

public class KedalamanActivity extends AppCompatActivity {
    CoordinatorLayout activity_kedalaman;
    RadioButton radio_kedalaman_1, radio_kedalaman_2, radio_kedalaman_3;
    ImageView info_kedalaman;
    FloatingActionButton fab_kedalaman;
    Integer kedalaman = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kedalaman);

        getSupportActionBar().setTitle("Kedalaman");
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        activity_kedalaman = (CoordinatorLayout) findViewById(R.id.activity_kedalaman);
        radio_kedalaman_1 = (RadioButton) findViewById(R.id.radio_kedalaman_1);
        radio_kedalaman_2 = (RadioButton) findViewById(R.id.radio_kedalaman_2);
        radio_kedalaman_3 = (RadioButton) findViewById(R.id.radio_kedalaman_3);
        info_kedalaman = (ImageView) findViewById(R.id.info_kedalaman);
        fab_kedalaman = (FloatingActionButton) findViewById(R.id.fab_kedalaman);

        radio_kedalaman_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    kedalaman = 1;
                }
            }
        });
        radio_kedalaman_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    kedalaman = 2;
                }
            }
        });
        radio_kedalaman_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    kedalaman = 3;
                }
            }
        });
        fab_kedalaman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kedalaman == 0) {
                    Snackbar.make(activity_kedalaman, "Pilih kedalaman.", Snackbar.LENGTH_SHORT).show();
                } else {
                    UserData.transaksi.setKedalaman(kedalaman);
                    Intent intent = new Intent(KedalamanActivity.this, KecepatanArusActivity.class);
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
