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

public class SubstratDasarPantaiActivity extends AppCompatActivity {
    CoordinatorLayout activity_substrat_dasar_pantai;
    RadioButton radio_substratdasarpantai_3, radio_substratdasarpantai_2, radio_substratdasarpantai_1;
    ImageView info_substratdasarpantai;
    Integer substratdasarpantai = 0;
    FloatingActionButton fab_substrat_dasar_pantai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_substrat_dasar_pantai);

        getSupportActionBar().setTitle("Substrat Dasar Pantai");
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        activity_substrat_dasar_pantai = (CoordinatorLayout) findViewById(R.id.activity_substrat_dasar_pantai);
        radio_substratdasarpantai_1 = (RadioButton) findViewById(R.id.radio_substratdasarpantai_1);
        radio_substratdasarpantai_2 = (RadioButton) findViewById(R.id.radio_substratdasarpantai_2);
        radio_substratdasarpantai_3 = (RadioButton) findViewById(R.id.radio_substratdasarpantai_3);
        info_substratdasarpantai = (ImageView) findViewById(R.id.info_substratdasarpantai);
        fab_substrat_dasar_pantai = (FloatingActionButton) findViewById(R.id.fab_substrat_dasar_pantai);

        radio_substratdasarpantai_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    substratdasarpantai = 1;
                }
            }
        });
        radio_substratdasarpantai_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    substratdasarpantai = 2;
                }
            }
        });
        radio_substratdasarpantai_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    substratdasarpantai = 3;
                }
            }
        });

        fab_substrat_dasar_pantai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (substratdasarpantai == 0){
                    Snackbar.make(activity_substrat_dasar_pantai, "Pilih substrat dasar pantai.", Snackbar.LENGTH_SHORT).show();
                } else {
                    UserData.transaksi.setSubstrat_dasar_pantai(substratdasarpantai);
                    Intent intent = new Intent(SubstratDasarPantaiActivity.this, SalinitasActivity.class);
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
