package com.ailynx.pekatala.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.ailynx.pekatala.R;
import com.ailynx.pekatala.data.UserData;

import static com.ailynx.pekatala.data.UserData.bulan;
import static com.ailynx.pekatala.data.UserData.kota_kabupaten;
import static com.ailynx.pekatala.data.UserData.waktu;

public class WaktuTanamActivity extends AppCompatActivity {
    Spinner spinner_kota_kabupaten, spinner_provinsi, spinner_bulan, spinner_waktu;
    FloatingActionButton fab_waktu_tanam;

    Integer provinsi_fix, kota_kabupaten_fix, bulan_fix, waktu_fix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waktu_tanam);

        getSupportActionBar().setSubtitle("Waktu Tanam");
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        spinner_provinsi = (Spinner) findViewById(R.id.spinner_provinsi);
        spinner_kota_kabupaten = (Spinner) findViewById(R.id.spinner_kota_kabupaten);
        spinner_bulan = (Spinner) findViewById(R.id.spinner_bulan);
        spinner_waktu = (Spinner) findViewById(R.id.spinner_waktu);
        fab_waktu_tanam = (FloatingActionButton) findViewById(R.id.fab_waktu_tanam);

        spinner_provinsi.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, UserData.provinsi));
        spinner_provinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                provinsi_fix = position + 1;
                spinner_kota_kabupaten.setAdapter(new ArrayAdapter<String>(WaktuTanamActivity.this, android.R.layout.simple_spinner_dropdown_item, kota_kabupaten[position]));
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
                bulan_fix = position+1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner_waktu.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, waktu));
        spinner_waktu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                waktu_fix = position+1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        fab_waktu_tanam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*TempData.PROVINSI = provinsi_fix;
                TempData.KOTA_KABUPATEN = kota_kabupaten_fix;
                TempData.BULAN = bulan_fix;
                TempData.WAKTU = waktu_fix;
                TempData.isiWaktuTanam = true;*/
                Snackbar.make(v, "Transaksi telah disimpan.", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        /*if (TempData.PROVINSI != 0){
            spinner_provinsi.setSelection(TempData.PROVINSI-1);
            if (TempData.KOTA_KABUPATEN != 0){
                spinner_kota_kabupaten.setSelection(TempData.KOTA_KABUPATEN-1);
            }
        }
        if (TempData.BULAN != 0){
            spinner_bulan.setSelection(TempData.BULAN-1);
        }
        if (TempData.WAKTU != 0){
            spinner_waktu.setSelection(TempData.WAKTU-1);
        }*/
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
