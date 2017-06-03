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

public class KeterlindunganActivity extends AppCompatActivity {
    CoordinatorLayout activity_keterlindungan;
    RadioButton radio_keterlindungan_1, radio_keterlindungan_2, radio_keterlindungan_3;
    ImageView info_keterlindungan;
    Integer keterlindungan = 0;
    FloatingActionButton fab_keterlindungan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keterlindungan);

        getSupportActionBar().setTitle("Keterlindungan");
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        activity_keterlindungan = (CoordinatorLayout) findViewById(R.id.activity_keterlindungan);
        radio_keterlindungan_1 = (RadioButton) findViewById(R.id.radio_keterlindungan_1);
        radio_keterlindungan_2 = (RadioButton) findViewById(R.id.radio_keterlindungan_2);
        radio_keterlindungan_3 = (RadioButton) findViewById(R.id.radio_keterlindungan_3);
        info_keterlindungan = (ImageView) findViewById(R.id.info_keterlindungan);
        fab_keterlindungan = (FloatingActionButton) findViewById(R.id.fab_keterlindungan);

        radio_keterlindungan_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    keterlindungan = 1;
                }
            }
        });
        radio_keterlindungan_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    keterlindungan = 2;
                }
            }
        });
        radio_keterlindungan_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    keterlindungan = 3;
                }
            }
        });
        fab_keterlindungan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (keterlindungan == 0){
                    Snackbar.make(activity_keterlindungan, "Pilih keterlindungan.", Snackbar.LENGTH_SHORT).show();
                } else {
                    UserData.transaksi.setKeterlindungan(keterlindungan);
                    Intent intent = new Intent(KeterlindunganActivity.this, PencemarActivity.class);
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
