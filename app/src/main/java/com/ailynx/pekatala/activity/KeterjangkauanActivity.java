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

public class KeterjangkauanActivity extends AppCompatActivity {
    CoordinatorLayout activity_keterjangkauan;
    RadioButton radio_keterjangkauan_1, radio_keterjangkauan_2, radio_keterjangkauan_3;
    ImageView info_keterjangkauan;
    Integer keterjangkauan = 0;
    FloatingActionButton fab_keterjangkauan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keterjangkauan);

        getSupportActionBar().setTitle("Keterjangkauan");
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        activity_keterjangkauan = (CoordinatorLayout) findViewById(R.id.activity_keterjangkauan);
        radio_keterjangkauan_1 = (RadioButton) findViewById(R.id.radio_keterjangkauan_1);
        radio_keterjangkauan_2 = (RadioButton) findViewById(R.id.radio_keterjangkauan_2);
        radio_keterjangkauan_3 = (RadioButton) findViewById(R.id.radio_keterjangkauan_3);
        info_keterjangkauan = (ImageView) findViewById(R.id.info_keterjangkauan);
        fab_keterjangkauan = (FloatingActionButton) findViewById(R.id.fab_keterjangkauan);

        radio_keterjangkauan_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    keterjangkauan = 1;
                }
            }
        });
        radio_keterjangkauan_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    keterjangkauan = 2;
                }
            }
        });
        radio_keterjangkauan_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    keterjangkauan = 3;
                }
            }
        });
        fab_keterjangkauan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (keterjangkauan == 0) {
                    Snackbar.make(activity_keterjangkauan, "Pilih keterjangkauan.", Snackbar.LENGTH_SHORT).show();
                } else {
                    UserData.transaksi.setKeterjangkauan(keterjangkauan);
                    Intent intent = new Intent(KeterjangkauanActivity.this, KeterlindunganActivity.class);
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
