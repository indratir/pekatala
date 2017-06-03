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

import com.ailynx.pekatala.R;
import com.ailynx.pekatala.controller.PostDataController;

public class Part3Activity extends AppCompatActivity {
    CoordinatorLayout activity_part3;
    FloatingActionButton fab_part3;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part3);

        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        activity_part3 = (CoordinatorLayout) findViewById(R.id.activity_part3);
        fab_part3 = (FloatingActionButton) findViewById(R.id.fab_part3);


        
        /*fab_part3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!radio_keterlindungan_1.isChecked() && !radio_keterlindungan_2.isChecked() && !radio_keterlindungan_3.isChecked()){
                    Snackbar.make(activity_part3, "Pilih Keterlindungan", Snackbar.LENGTH_SHORT).show();
                } else if (!radio_keterjangkauan_1.isChecked() && !radio_keterjangkauan_2.isChecked() && !radio_keterjangkauan_3.isChecked()){
                    Snackbar.make(activity_part3, "Pilih Keterjangkauan.", Snackbar.LENGTH_SHORT).show();
                } else if (!radio_pencemar_1.isChecked() && !radio_pencemar_2.isChecked() && !radio_pencemar_3.isChecked()){
                    Snackbar.make(activity_part3, "Pilih Pencemar.", Snackbar.LENGTH_SHORT).show();
                } else {
                    new startPost().execute();
                }
            }
        });*/

    }

    private void startIntent(){
        Intent intent = new Intent(Part3Activity.this, OutputActivity.class);
        startActivity(intent);
    }

    class startPost extends AsyncTask<String, String, String>{
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(Part3Activity.this);
            progressDialog.setIndeterminate(false);
            progressDialog.setCancelable(true);
            progressDialog.setMessage("Tunggu sebentar...");
            progressDialog.setTitle("Mengirim data");
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();
            if (s.equals("true")){
                startIntent();
            } else if (s.equals("false")){
                Snackbar.make(activity_part3, "Server sedang dalam perbaikan. Coba lagi", Snackbar.LENGTH_SHORT).show();
            } else {
                Snackbar.make(activity_part3, "Cek koneksi internet anda.", Snackbar.LENGTH_SHORT).show();
            }
        }

        @Override
        protected String doInBackground(String... params) {
            PostDataController controller = new PostDataController();
            String result = controller.execute();
            return result;
        }
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
