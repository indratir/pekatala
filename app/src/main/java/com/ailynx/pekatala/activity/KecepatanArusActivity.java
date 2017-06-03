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

public class KecepatanArusActivity extends AppCompatActivity {
    CoordinatorLayout activity_kecepatan_arus;
    RadioButton radio_kecepatanarus_1, radio_kecepatanarus_2, radio_kecepatanarus_3;
    ImageView info_kecepatanarus;
    FloatingActionButton fab_kecepatan_arus;
    Integer kecepatanarus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kecepatan_arus);

        getSupportActionBar().setTitle("Kecepatan Arus");
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        activity_kecepatan_arus = (CoordinatorLayout) findViewById(R.id.activity_kecepatan_arus);
        radio_kecepatanarus_1 = (RadioButton) findViewById(R.id.radio_kecepatanarus_1);
        radio_kecepatanarus_2 = (RadioButton) findViewById(R.id.radio_kecepatanarus_2);
        radio_kecepatanarus_3 = (RadioButton) findViewById(R.id.radio_kecepatanarus_3);
        info_kecepatanarus = (ImageView) findViewById(R.id.info_kecepatanarus);
        fab_kecepatan_arus = (FloatingActionButton) findViewById(R.id.fab_kecepatan_arus);

        radio_kecepatanarus_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    kecepatanarus = 1;
                }
            }
        });
        radio_kecepatanarus_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    kecepatanarus = 2;
                }
            }
        });
        radio_kecepatanarus_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    kecepatanarus = 3;
                }
            }
        });

        fab_kecepatan_arus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kecepatanarus == 0) {
                    Snackbar.make(activity_kecepatan_arus, "Pilih kecepatan arus.", Snackbar.LENGTH_SHORT).show();
                } else {
                    UserData.transaksi.setKecepatan_arus(kecepatanarus);
                    Intent intent = new Intent(KecepatanArusActivity.this, SubstratDasarPantaiActivity.class);
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
