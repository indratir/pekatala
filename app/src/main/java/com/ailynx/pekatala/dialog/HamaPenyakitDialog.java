package com.ailynx.pekatala.dialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.ailynx.pekatala.R;

public class HamaPenyakitDialog extends AppCompatActivity {
    TextView title_hama_penyakit, text_hama_penyakit;
    ImageView img_hama_penyakit;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_hama_penyakit);

        id = getIntent().getIntExtra("id", 0);
        title_hama_penyakit = (TextView) findViewById(R.id.title_hama_penyakit);
        text_hama_penyakit = (TextView) findViewById(R.id.text_hama_penyakit);
        img_hama_penyakit = (ImageView) findViewById(R.id.img_hama_penyakit);

        if (id == R.id.info_hama_ikan){
            title_hama_penyakit.setText(R.string.label_ikan);
            text_hama_penyakit.setText(R.string.deskripsi_ikan);
            img_hama_penyakit.setImageResource(R.drawable.hama_ikan);
        } else if (id == R.id.info_hama_gulma){
            title_hama_penyakit.setText(R.string.label_gulma);
            text_hama_penyakit.setText(R.string.deskripsi_gulma);
            img_hama_penyakit.setImageResource(R.drawable.not_found);
        } else if (id == R.id.info_penyakit_iceice){
            title_hama_penyakit.setText(R.string.label_iceice);
            text_hama_penyakit.setText(R.string.deskripsi_iceice);
            img_hama_penyakit.setImageResource(R.drawable.penyakit_iceice);
        } else {
            title_hama_penyakit.setText("Unknown");
            text_hama_penyakit.setText(R.string.lipsum);
            img_hama_penyakit.setImageResource(R.drawable.not_found);
        }
    }
}
