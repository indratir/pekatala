package com.ailynx.pekatala.activity;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.ailynx.pekatala.R;

public class Part1Activity extends AppCompatActivity {
    CoordinatorLayout activity_part1;

    FloatingActionButton fab_part1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part1);

        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        activity_part1 = (CoordinatorLayout) findViewById(R.id.activity_part1);

        fab_part1 = (FloatingActionButton) findViewById(R.id.fab_part1);
        
        /*fab_part1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!radio_salinitas_1.isChecked() && !radio_salinitas_2.isChecked() && !radio_salinitas_3.isChecked()){
                    Snackbar.make(activity_part1, "Pilih Salinitas.", Snackbar.LENGTH_SHORT).show();
                } else if (!radio_kecerahan_1.isChecked() && !radio_kecerahan_2.isChecked() && !radio_kecerahan_3.isChecked()){
                    Snackbar.make(activity_part1, "Pilih Kecerahan.", Snackbar.LENGTH_SHORT).show();
                } else if (!radio_suhu_1.isChecked() && !radio_suhu_2.isChecked() && !radio_suhu_3.isChecked()){
                    Snackbar.make(activity_part1, "Pilih Suhu.", Snackbar.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(Part1Activity.this, Part2Activity.class);
                    startActivity(intent);
                }
            }
        });*/
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
