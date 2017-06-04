package com.ailynx.pekatala.activity;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.ailynx.pekatala.R;
import com.ailynx.pekatala.data.UserData;

import static com.ailynx.pekatala.data.UserData.bulan;
import static com.ailynx.pekatala.data.UserData.kota_kabupaten;
import static com.ailynx.pekatala.data.UserData.waktu;

public class MainActivity extends AppCompatActivity {
    CoordinatorLayout activity_main;
    RadioButton radio_tanam_pernah, radio_tanam_tdkpernah;
    Spinner spinner_kota_kabupaten, spinner_provinsi, spinner_bulan, spinner_waktu;
    FloatingActionButton fab_main;
    Integer provinsi_fix, kota_kabupaten_fix, bulan_fix, waktu_fix, pernah_tanam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Lokasi & Waktu Tanam");
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        activity_main = (CoordinatorLayout) findViewById(R.id.activity_main);
        radio_tanam_pernah = (RadioButton) findViewById(R.id.radio_tanam_pernah);
        radio_tanam_tdkpernah = (RadioButton) findViewById(R.id.radio_tanam_tdkpernah);
        spinner_provinsi = (Spinner) findViewById(R.id.spinner_provinsi);
        spinner_kota_kabupaten = (Spinner) findViewById(R.id.spinner_kota_kabupaten);
        spinner_bulan = (Spinner) findViewById(R.id.spinner_bulan);
        spinner_waktu = (Spinner) findViewById(R.id.spinner_waktu);
        fab_main = (FloatingActionButton) findViewById(R.id.fab_main);

        radio_tanam_pernah.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    pernah_tanam = 1;
                } else {
                    pernah_tanam = 0;
                }
            }
        });
        radio_tanam_pernah.setChecked(true);

        fab_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!radio_tanam_pernah.isChecked() && !radio_tanam_tdkpernah.isChecked()) {
                    Snackbar.make(activity_main, "Pilih jawaban anda terlebih dahulu.", Snackbar.LENGTH_SHORT).show();
                } else {
                    UserData.transaksi.setProvinsi(provinsi_fix);
                    UserData.transaksi.setKota_kabupaten(kota_kabupaten_fix);
                    UserData.transaksi.setBulan(bulan_fix);
                    UserData.transaksi.setWaktu(waktu_fix);
                    UserData.transaksi.setPernah_tanam(pernah_tanam);

                    if (pernah_tanam == 1) {
                        UserData.transaksi.setKedalaman(0);
                        UserData.transaksi.setSubstrat_dasar_pantai(0);
                        Intent intent = new Intent(MainActivity.this, SalinitasActivity.class);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(MainActivity.this, KedalamanActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });

        spinner_provinsi.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, UserData.provinsi));
        spinner_provinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                provinsi_fix = position + 1;
                spinner_kota_kabupaten.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, kota_kabupaten[position]));
                spinner_kota_kabupaten.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position2, long id) {
                        kota_kabupaten_fix = position + 1;
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner_bulan.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, bulan));
        spinner_bulan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bulan_fix = position + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner_waktu.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, waktu));
        spinner_waktu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                waktu_fix = position + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
