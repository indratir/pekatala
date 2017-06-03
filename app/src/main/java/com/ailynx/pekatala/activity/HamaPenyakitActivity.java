package com.ailynx.pekatala.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.ailynx.pekatala.R;
import com.ailynx.pekatala.controller.PostDataController;
import com.ailynx.pekatala.data.UserData;
import com.ailynx.pekatala.dialog.HamaPenyakitDialog;

public class HamaPenyakitActivity extends AppCompatActivity {
    CoordinatorLayout activity_hama_penyakit;
    CheckBox checkbox_hama_ikan, checkbox_hama_gulma, checkbox_penyakit_iceice;
    ImageView info_hama_ikan, info_hama_gulma, info_penyakit_iceice;
    Integer ikan = 0, gulma = 0, iceice = 0;
    FloatingActionButton fab_hama_penyakit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hama_penyakit);

        getSupportActionBar().setTitle("Hama dan Penyakit");
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        activity_hama_penyakit = (CoordinatorLayout) findViewById(R.id.activity_hama_penyakit);
        checkbox_hama_ikan = (CheckBox) findViewById(R.id.checkbox_hama_ikan);
        checkbox_hama_gulma = (CheckBox) findViewById(R.id.checkbox_hama_gulma);
        checkbox_penyakit_iceice = (CheckBox) findViewById(R.id.checkbox_penyakit_iceice);
        info_hama_ikan = (ImageView) findViewById(R.id.info_hama_ikan);
        info_hama_gulma = (ImageView) findViewById(R.id.info_hama_gulma);
        info_penyakit_iceice = (ImageView) findViewById(R.id.info_penyakit_iceice);
        fab_hama_penyakit = (FloatingActionButton) findViewById(R.id.fab_hama_penyakit);

        checkbox_hama_ikan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ikan = 1;
                } else {
                    ikan = 0;
                }
            }
        });
        checkbox_hama_gulma.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    gulma = 1;
                } else {
                    gulma = 0;
                }
            }
        });
        checkbox_penyakit_iceice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    iceice = 1;
                } else {
                    iceice = 0;
                }
            }
        });

        info_hama_ikan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callHamaPenyakitDialog(R.id.info_hama_ikan);
            }
        });
        info_hama_gulma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callHamaPenyakitDialog(R.id.info_hama_gulma);
            }
        });
        info_penyakit_iceice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callHamaPenyakitDialog(R.id.info_penyakit_iceice);
            }
        });
        fab_hama_penyakit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserData.transaksi.setHama_ikan(ikan);
                UserData.transaksi.setHama_gulma(gulma);
                UserData.transaksi.setPenyakit_iceice(iceice);

                new saveData().execute();
            }
        });
    }

    class saveData extends AsyncTask<String, String, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(HamaPenyakitActivity.this);
            progressDialog.setTitle("Pengiriman Data");
            progressDialog.setMessage("Tunggu sebentar...");
            progressDialog.setIndeterminate(false);
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressDialog.dismiss();
            if (s.equals("true")) {
                Intent intent = new Intent(HamaPenyakitActivity.this, OutputActivity.class);
                startActivity(intent);
            } else if (s.equals("false") || s.equals("failed")) {
                Snackbar.make(activity_hama_penyakit, "Terjadi kesalahan pada server.", Snackbar.LENGTH_SHORT).show();
            } else if (s.equals("json_error")) {
                Snackbar.make(activity_hama_penyakit, "Terjadi kesalahan saat memproses data.", Snackbar.LENGTH_SHORT).show();
            } else if (s.equals("network_error")) {
                Snackbar.make(activity_hama_penyakit, "Cek koneksi internet anda.", Snackbar.LENGTH_SHORT).show();
            }
        }

        @Override
        protected String doInBackground(String... params) {
            PostDataController controller = new PostDataController();
            String result = controller.execute();
            if (result.equals("true")){
                UserData.transaksi.save();
            }
            return result;
        }
    }

    private void callHamaPenyakitDialog(int id){
        Intent intent = new Intent(HamaPenyakitActivity.this, HamaPenyakitDialog.class);
        intent.putExtra("id", id);
        startActivity(intent);
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
