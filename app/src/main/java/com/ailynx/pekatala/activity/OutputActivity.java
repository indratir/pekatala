package com.ailynx.pekatala.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ailynx.pekatala.R;
import com.ailynx.pekatala.data.UserData;

public class OutputActivity extends AppCompatActivity {
    TextView text_saran, 
            text_hasil,
            tv_jawaban_salinitas,
            tv_jawaban_kecerahan,
            tv_jawaban_suhu,
            tv_jawaban_kedalaman,
            tv_jawaban_kecepatanarus,
            tv_jawaban_substratdasarpantai,
            tv_jawaban_keterjangkauan,
            tv_jawaban_keterlindungan,
            tv_jawaban_pencemar;
    Button btn_output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        getSupportActionBar().setTitle("Hasil Akhir");
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        text_hasil = (TextView) findViewById(R.id.text_hasil);
        text_saran = (TextView) findViewById(R.id.text_saran);
        tv_jawaban_salinitas = (TextView) findViewById(R.id.tv_jawaban_salinitas);
        tv_jawaban_kecerahan = (TextView) findViewById(R.id.tv_jawaban_kecerahan);
        tv_jawaban_suhu = (TextView) findViewById(R.id.tv_jawaban_suhu);
        tv_jawaban_kedalaman = (TextView) findViewById(R.id.tv_jawaban_kedalaman);
        tv_jawaban_kecepatanarus = (TextView) findViewById(R.id.tv_jawaban_kecepatanarus);
        tv_jawaban_substratdasarpantai = (TextView) findViewById(R.id.tv_jawaban_substratdasarpantai);
        tv_jawaban_keterjangkauan = (TextView) findViewById(R.id.tv_jawaban_keterjangkauan);
        tv_jawaban_keterlindungan = (TextView) findViewById(R.id.tv_jawaban_keterlindungan);
        tv_jawaban_pencemar = (TextView) findViewById(R.id.tv_jawaban_pencemar);
        btn_output = (Button) findViewById(R.id.btn_output);

        btn_output.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToHome();
            }
        });
        
        text_hasil.setText(UserData.transaksi.getInfo());
        text_saran.setText(UserData.transaksi.getSaran(this));
        
        switch (UserData.transaksi.getSalinitas()) {
            case 1:
                tv_jawaban_salinitas.setText(getString(R.string.jawaban_salinitas_1));
                break;
            case 2:
                tv_jawaban_salinitas.setText(getString(R.string.jawaban_salinitas_2));
                break;
            case 3:
                tv_jawaban_salinitas.setText(getString(R.string.jawaban_salinitas_3));
                break;
            default:
                break;
        }

        switch (UserData.transaksi.getKecerahan()) {
            case 1:
                tv_jawaban_kecerahan.setText(getString(R.string.jawaban_kecerahan_1));
                break;
            case 2:
                tv_jawaban_kecerahan.setText(getString(R.string.jawaban_kecerahan_2));
                break;
            case 3:
                tv_jawaban_kecerahan.setText(getString(R.string.jawaban_kecerahan_3));
                break;
            default:
                break;
        }

        switch (UserData.transaksi.getSuhu()) {
            case 1:
                tv_jawaban_suhu.setText(getString(R.string.jawaban_suhu_1));
                break;
            case 2:
                tv_jawaban_suhu.setText(getString(R.string.jawaban_suhu_2));
                break;
            case 3:
                tv_jawaban_suhu.setText(getString(R.string.jawaban_suhu_3));
                break;
            default:
                break;
        }

        switch (UserData.transaksi.getKedalaman()) {
            case 1:
                tv_jawaban_kedalaman.setText(getString(R.string.jawaban_kedalaman_1));
                break;
            case 2:
                tv_jawaban_kedalaman.setText(getString(R.string.jawaban_kedalaman_2));
                break;
            case 3:
                tv_jawaban_kedalaman.setText(getString(R.string.jawaban_kedalaman_3));
                break;
            default:
                break;
        }

        switch (UserData.transaksi.getKecepatan_arus()) {
            case 1:
                tv_jawaban_kecepatanarus.setText(getString(R.string.jawaban_kecepatanarus_1));
                break;
            case 2:
                tv_jawaban_kecepatanarus.setText(getString(R.string.jawaban_kecepatanarus_2));
                break;
            case 3:
                tv_jawaban_kecepatanarus.setText(getString(R.string.jawaban_kecepatanarus_3));
                break;
            default:
                break;
        }

        switch (UserData.transaksi.getSubstrat_dasar_pantai()) {
            case 1:
                tv_jawaban_substratdasarpantai.setText(getString(R.string.jawaban_substratdasarpantai_1));
                break;
            case 2:
                tv_jawaban_substratdasarpantai.setText(getString(R.string.jawaban_substratdasarpantai_2));
                break;
            case 3:
                tv_jawaban_substratdasarpantai.setText(getString(R.string.jawaban_substratdasarpantai_3));
                break;
            default:
                break;
        }

        switch (UserData.transaksi.getKeterjangkauan()) {
            case 1:
                tv_jawaban_keterjangkauan.setText(getString(R.string.jawaban_keterjangkauan_1));
                break;
            case 2:
                tv_jawaban_keterjangkauan.setText(getString(R.string.jawaban_keterjangkauan_2));
                break;
            case 3:
                tv_jawaban_keterjangkauan.setText(getString(R.string.jawaban_keterjangkauan_3));
                break;
            default:
                break;
        }

        switch (UserData.transaksi.getKeterlindungan()) {
            case 1:
                tv_jawaban_keterlindungan.setText(getString(R.string.jawaban_keterlindungan_1));
                break;
            case 2:
                tv_jawaban_keterlindungan.setText(getString(R.string.jawaban_keterlindungan_2));
                break;
            case 3:
                tv_jawaban_keterlindungan.setText(getString(R.string.jawaban_keterlindungan_3));
                break;
            default:
                break;
        }

        switch (UserData.transaksi.getPencemar()) {
            case 1:
                tv_jawaban_pencemar.setText(getString(R.string.jawaban_pencemar_1));
                break;
            case 2:
                tv_jawaban_pencemar.setText(getString(R.string.jawaban_pencemar_2));
                break;
            case 3:
                tv_jawaban_pencemar.setText(getString(R.string.jawaban_pencemar_3));
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        backToHome();
    }

    private void backToHome(){
        Intent intent = new Intent(OutputActivity.this, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                backToHome();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
