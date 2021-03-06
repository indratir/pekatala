package com.ailynx.pekatala.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ailynx.pekatala.R;
import com.ailynx.pekatala.data.UserData;

public class OutputActivity extends AppCompatActivity {
    ImageView iv_hasil;
    TextView text_saran,
            text_hasil,
            tv_jawaban_salinitas,
            tv_jawaban_kecerahan,
            tv_jawaban_suhu,
            tv_jawaban_kedalaman,
            tv_jawaban_substratdasarpantai;
    LinearLayout ll_jawaban_salinitas,
            ll_jawaban_kecerahan,
            ll_jawaban_suhu,
            ll_jawaban_kedalaman,
            ll_jawaban_substratdasarpantai;
    Button btn_output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        getSupportActionBar().setTitle("Hasil Akhir");
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        iv_hasil = (ImageView) findViewById(R.id.iv_hasil);
        text_hasil = (TextView) findViewById(R.id.text_hasil);
        text_saran = (TextView) findViewById(R.id.text_saran);
        tv_jawaban_salinitas = (TextView) findViewById(R.id.tv_jawaban_salinitas);
        tv_jawaban_kecerahan = (TextView) findViewById(R.id.tv_jawaban_kecerahan);
        tv_jawaban_suhu = (TextView) findViewById(R.id.tv_jawaban_suhu);
        tv_jawaban_kedalaman = (TextView) findViewById(R.id.tv_jawaban_kedalaman);
        tv_jawaban_substratdasarpantai = (TextView) findViewById(R.id.tv_jawaban_substratdasarpantai);
        ll_jawaban_salinitas = (LinearLayout) findViewById(R.id.ll_jawaban_salinitas);
        ll_jawaban_kecerahan = (LinearLayout) findViewById(R.id.ll_jawaban_kecerahan);
        ll_jawaban_suhu = (LinearLayout) findViewById(R.id.ll_jawaban_suhu);
        ll_jawaban_kedalaman = (LinearLayout) findViewById(R.id.ll_jawaban_kedalaman);
        ll_jawaban_substratdasarpantai = (LinearLayout) findViewById(R.id.ll_jawaban_substratdasarpantai);
        btn_output = (Button) findViewById(R.id.btn_output);

        btn_output.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToHome();
            }
        });

        iv_hasil.setImageResource(UserData.transaksi.getLogoId());
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

        if (UserData.transaksi.getPernah_tanam() == 0){
            ll_jawaban_kedalaman.setVisibility(View.VISIBLE);
            ll_jawaban_substratdasarpantai.setVisibility(View.VISIBLE);

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
        } else {
            ll_jawaban_kedalaman.setVisibility(View.GONE);
            ll_jawaban_substratdasarpantai.setVisibility(View.GONE);
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
