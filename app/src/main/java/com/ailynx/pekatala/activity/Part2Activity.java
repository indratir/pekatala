package com.ailynx.pekatala.activity;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.ailynx.pekatala.R;

public class Part2Activity extends AppCompatActivity {
    CoordinatorLayout activity_part2;
    FloatingActionButton fab_part2;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part2);

        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        activity_part2 = (CoordinatorLayout) findViewById(R.id.activity_part2);

        fab_part2 = (FloatingActionButton) findViewById(R.id.fab_part2);


        
        /*fab_part2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!radio_kedalaman_1.isChecked() && !radio_kedalaman_2.isChecked() && !radio_kedalaman_3.isChecked()){
                    Snackbar.make(activity_part2, "Pilih Kedalaman.", Snackbar.LENGTH_SHORT).show();
                } else if (!radio_kecepatanarus_1.isChecked() && !radio_kecepatanarus_2.isChecked() && !radio_kecepatanarus_3.isChecked()){
                    Snackbar.make(activity_part2, "Pilih Kecepatan Arus.", Snackbar.LENGTH_SHORT).show();
                } else if (!radio_substratdasarpantai_1.isChecked() && !radio_substratdasarpantai_2.isChecked() && !radio_substratdasarpantai_3.isChecked()){
                    Snackbar.make(activity_part2, "Pilih Substrat Dasar Pantai.", Snackbar.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(Part2Activity.this, Part3Activity.class);
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
