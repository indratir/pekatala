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

public class SuhuActivity extends AppCompatActivity {
    CoordinatorLayout activity_suhu;
    RadioButton radio_suhu_3, radio_suhu_2, radio_suhu_1;
    ImageView info_suhu;
    Integer suhu = 0;
    FloatingActionButton fab_suhu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suhu);

        getSupportActionBar().setTitle("Suhu");
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        activity_suhu = (CoordinatorLayout) findViewById(R.id.activity_suhu);
        radio_suhu_1 = (RadioButton) findViewById(R.id.radio_suhu_1);
        radio_suhu_2 = (RadioButton) findViewById(R.id.radio_suhu_2);
        radio_suhu_3 = (RadioButton) findViewById(R.id.radio_suhu_3);
        info_suhu = (ImageView) findViewById(R.id.info_suhu);
        fab_suhu = (FloatingActionButton) findViewById(R.id.fab_suhu);

        radio_suhu_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    suhu = 1;
                }
            }
        });
        radio_suhu_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    suhu = 2;
                }
            }
        });
        radio_suhu_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    suhu = 3;
                }
            }
        });
        fab_suhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (suhu == 0) {
                    Snackbar.make(activity_suhu, "Pilih suhu.", Snackbar.LENGTH_SHORT).show();
                } else {
                    UserData.transaksi.setSuhu(suhu);
                    Intent intent = new Intent(SuhuActivity.this, HamaPenyakitActivity.class);
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
