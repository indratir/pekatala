package com.ailynx.pekatala.activity;

import android.content.Intent;
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
import com.ailynx.pekatala.dialog.KualitasAirDialog;

public class KualitasAirActivity extends AppCompatActivity {
    RadioButton radio_salinitas_1, radio_salinitas_2, radio_salinitas_3, radio_kecerahan_1, radio_kecerahan_2, radio_kecerahan_3, radio_suhu_3, radio_suhu_2, radio_suhu_1, radio_kedalaman_1, radio_kedalaman_2, radio_kedalaman_3, radio_kecepatanarus_1, radio_kecepatanarus_2, radio_kecepatanarus_3, radio_substratdasarpantai_3, radio_substratdasarpantai_2, radio_substratdasarpantai_1, radio_keterlindungan_1, radio_keterlindungan_2, radio_keterlindungan_3, radio_keterjangkauan_1, radio_keterjangkauan_2, radio_keterjangkauan_3, radio_pencemar_3, radio_pencemar_2, radio_pencemar_1;
    ImageView info_salinitas, info_kecerahan, info_suhu, info_kedalaman, info_kecepatanarus, info_substratdasarpantai, info_keterjangkauan, info_keterlindungan, info_pencemar;
    FloatingActionButton fab_kualitas_air;
    Integer salinitas, kecerahan, suhu, kedalaman, kecepatanarus, substratdasarpantai, keterjangkauan, keterlindungan, pencemar; 
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kualitas_air);

        getSupportActionBar().setSubtitle("Kualitas Air");
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        radio_salinitas_1 = (RadioButton) findViewById(R.id.radio_salinitas_1);
        radio_salinitas_2 = (RadioButton) findViewById(R.id.radio_salinitas_2);
        radio_salinitas_3 = (RadioButton) findViewById(R.id.radio_salinitas_3);
        radio_kecerahan_1 = (RadioButton) findViewById(R.id.radio_kecerahan_1);
        radio_kecerahan_2 = (RadioButton) findViewById(R.id.radio_kecerahan_2);
        radio_kecerahan_3 = (RadioButton) findViewById(R.id.radio_kecerahan_3);
        radio_suhu_1 = (RadioButton) findViewById(R.id.radio_suhu_1);
        radio_suhu_2 = (RadioButton) findViewById(R.id.radio_suhu_2);
        radio_suhu_3 = (RadioButton) findViewById(R.id.radio_suhu_3);
        radio_kedalaman_1 = (RadioButton) findViewById(R.id.radio_kedalaman_1);
        radio_kedalaman_2 = (RadioButton) findViewById(R.id.radio_kedalaman_2);
        radio_kedalaman_3 = (RadioButton) findViewById(R.id.radio_kedalaman_3);
        radio_kecepatanarus_1 = (RadioButton) findViewById(R.id.radio_kecepatanarus_1);
        radio_kecepatanarus_2 = (RadioButton) findViewById(R.id.radio_kecepatanarus_2);
        radio_kecepatanarus_3 = (RadioButton) findViewById(R.id.radio_kecepatanarus_3);
        radio_substratdasarpantai_1 = (RadioButton) findViewById(R.id.radio_substratdasarpantai_1);
        radio_substratdasarpantai_2 = (RadioButton) findViewById(R.id.radio_substratdasarpantai_2);
        radio_substratdasarpantai_3 = (RadioButton) findViewById(R.id.radio_substratdasarpantai_3);
        radio_keterlindungan_1 = (RadioButton) findViewById(R.id.radio_keterlindungan_1);
        radio_keterlindungan_2 = (RadioButton) findViewById(R.id.radio_keterlindungan_2);
        radio_keterlindungan_3 = (RadioButton) findViewById(R.id.radio_keterlindungan_3);
        radio_keterjangkauan_1 = (RadioButton) findViewById(R.id.radio_keterjangkauan_1);
        radio_keterjangkauan_2 = (RadioButton) findViewById(R.id.radio_keterjangkauan_2);
        radio_keterjangkauan_3 = (RadioButton) findViewById(R.id.radio_keterjangkauan_3);
        radio_pencemar_1 = (RadioButton) findViewById(R.id.radio_pencemar_1);
        radio_pencemar_2 = (RadioButton) findViewById(R.id.radio_pencemar_2);
        radio_pencemar_3 = (RadioButton) findViewById(R.id.radio_pencemar_3);
        info_salinitas = (ImageView) findViewById(R.id.info_salinitas);
        info_kecerahan = (ImageView) findViewById(R.id.info_kecerahan);
        info_suhu = (ImageView) findViewById(R.id.info_suhu);
        info_kedalaman = (ImageView) findViewById(R.id.info_kedalaman);
        info_kecepatanarus = (ImageView) findViewById(R.id.info_kecepatanarus);
        info_substratdasarpantai = (ImageView) findViewById(R.id.info_substratdasarpantai);
        info_keterlindungan = (ImageView) findViewById(R.id.info_keterlindungan);
        info_keterjangkauan = (ImageView) findViewById(R.id.info_keterjangkauan);
        info_pencemar = (ImageView) findViewById(R.id.info_pencemar);
        fab_kualitas_air = (FloatingActionButton) findViewById(R.id.fab_kualitas_air);
        
        radio_salinitas_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    salinitas = 1;
                }
            }
        });
        radio_salinitas_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    salinitas = 2;
                }
            }
        });
        radio_salinitas_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    salinitas = 3;
                }
            }
        });
        radio_kecerahan_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    kecerahan = 1;
                }
            }
        });
        radio_kecerahan_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    kecerahan = 2;
                }
            }
        });
        radio_kecerahan_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    kecerahan = 3;
                }
            }
        });
        radio_suhu_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    suhu = 1;
                }
            }
        });
        radio_suhu_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    suhu = 2;
                }
            }
        });
        radio_suhu_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    suhu = 3;
                }
            }
        });
        radio_kedalaman_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    kedalaman = 1;
                }
            }
        });
        radio_kedalaman_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    kedalaman = 2;
                }
            }
        });
        radio_kedalaman_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    kedalaman = 3;
                }
            }
        });
        radio_kecepatanarus_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    kecepatanarus = 1;
                }
            }
        });
        radio_kecepatanarus_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    kecepatanarus = 2;
                }
            }
        });
        radio_kecepatanarus_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    kecepatanarus = 3;
                }
            }
        });
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
        radio_keterlindungan_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    keterlindungan = 1;
                }
            }
        });
        radio_keterlindungan_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    keterlindungan = 2;
                }
            }
        });
        radio_keterlindungan_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    keterlindungan = 3;
                }
            }
        });
        radio_keterjangkauan_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    keterjangkauan = 1;
                }
            }
        });
        radio_keterjangkauan_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    keterjangkauan = 2;
                }
            }
        });
        radio_keterjangkauan_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    keterjangkauan = 3;
                }
            }
        });
        radio_pencemar_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    pencemar = 1;
                }
            }
        });
        radio_pencemar_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    pencemar = 2;
                }
            }
        });
        radio_pencemar_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    pencemar = 3;
                }
            }
        });
        info_salinitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callKualitasAirDialog(R.id.info_salinitas);
            }
        });
        info_kecerahan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callKualitasAirDialog(R.id.info_kecerahan);
            }
        });
        info_suhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callKualitasAirDialog(R.id.info_suhu);
            }
        });
        info_kedalaman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callKualitasAirDialog(R.id.info_kedalaman);
            }
        });
        info_kecepatanarus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callKualitasAirDialog(R.id.info_kecepatanarus);
            }
        });
        info_substratdasarpantai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callKualitasAirDialog(R.id.info_substratdasarpantai);
            }
        });
        info_keterlindungan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callKualitasAirDialog(R.id.info_keterlindungan);
            }
        });
        info_keterjangkauan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callKualitasAirDialog(R.id.info_keterjangkauan);
            }
        });
        info_pencemar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callKualitasAirDialog(R.id.info_pencemar);
            }
        });
        fab_kualitas_air.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (salinitas.equals(0) || kecerahan.equals(0) || suhu.equals(0) || kedalaman.equals(0) || kecepatanarus.equals(0) || substratdasarpantai.equals(0) || keterjangkauan.equals(0) || keterlindungan.equals(0) || pencemar.equals(0)){
                    Snackbar.make(v, "Pastikan semua data telah diisi.", Snackbar.LENGTH_SHORT).show();
                } else {
                    /*TempData.SALINITAS = salinitas;
                    TempData.KECERAHAN = kecerahan;
                    TempData.SUHU = suhu;
                    TempData.KEDALAMAN = kedalaman;
                    TempData.KECEPATAN_ARUS = kecepatanarus;
                    TempData.SUBSTRAT_DASAR_PANTAI = substratdasarpantai;
                    TempData.KETERJANGKAUAN = keterjangkauan;
                    TempData.KETERLINDUNGAN = keterlindungan;
                    TempData.PENCEMAR = pencemar;
                    TempData.isiKualitasAir = true;*/
                    Snackbar.make(v, "Transaksi telah disimpan.", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void callKualitasAirDialog(int id){
        Intent intent = new Intent(KualitasAirActivity.this, KualitasAirDialog.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        
        /*switch (TempData.SALINITAS){
            case 1:
                radio_salinitas_1.setChecked(true);
                salinitas = 1;
                break;
            case 2:
                radio_salinitas_2.setChecked(true);
                salinitas = 2;
                break;
            case 3:
                radio_salinitas_3.setChecked(true);
                salinitas = 3;
                break;
            default:
                salinitas = 0;
                break;
        }
        switch (TempData.KECERAHAN){
            case 1:
                radio_kecerahan_1.setChecked(true);
                kecerahan = 1;
                break;
            case 2:
                radio_kecerahan_2.setChecked(true);
                kecerahan = 2;
                break;
            case 3:
                radio_kecerahan_3.setChecked(true);
                kecerahan = 3;
                break;
            default:
                kecerahan = 0;
                break;
        }
        switch (TempData.SUHU){
            case 1:
                radio_suhu_1.setChecked(true);
                suhu = 1;
                break;
            case 2:
                radio_suhu_2.setChecked(true);
                suhu = 2;
                break;
            case 3:
                radio_suhu_3.setChecked(true);
                suhu = 3;
                break;
            default:
                suhu = 0;
                break;
        }
        switch (TempData.KEDALAMAN){
            case 1:
                radio_kedalaman_1.setChecked(true);
                kedalaman = 1;
                break;
            case 2:
                radio_kedalaman_2.setChecked(true);
                kedalaman = 2;
                break;
            case 3:
                radio_kedalaman_3.setChecked(true);
                kedalaman = 3;
                break;
            default:
                kedalaman = 0;
                break;
        }
        switch (TempData.KECEPATAN_ARUS){
            case 1:
                radio_kecepatanarus_1.setChecked(true);
                kecepatanarus = 1;
                break;
            case 2:
                radio_kecepatanarus_2.setChecked(true);
                kecepatanarus = 2;
                break;
            case 3:
                radio_kecepatanarus_3.setChecked(true);
                kecepatanarus = 3;
                break;
            default:
                kecepatanarus = 0;
                break;
        }
        switch (TempData.SUBSTRAT_DASAR_PANTAI){
            case 1:
                radio_substratdasarpantai_1.setChecked(true);
                substratdasarpantai = 1;
                break;
            case 2:
                radio_substratdasarpantai_2.setChecked(true);
                substratdasarpantai = 2;
                break;
            case 3:
                radio_substratdasarpantai_3.setChecked(true);
                substratdasarpantai = 3;
                break;
            default:
                substratdasarpantai = 0;
                break;
        }
        switch (TempData.KETERJANGKAUAN){
            case 1:
                radio_keterjangkauan_1.setChecked(true);
                keterjangkauan = 1;
                break;
            case 2:
                radio_keterjangkauan_2.setChecked(true);
                keterjangkauan = 2;
                break;
            case 3:
                radio_keterjangkauan_3.setChecked(true);
                keterjangkauan = 3;
                break;
            default:
                keterjangkauan = 0;
                break;
        }
        switch (TempData.KETERLINDUNGAN){
            case 1:
                radio_keterlindungan_1.setChecked(true);
                keterlindungan = 1;
                break;
            case 2:
                radio_keterlindungan_2.setChecked(true);
                keterlindungan = 2;
                break;
            case 3:
                radio_keterlindungan_3.setChecked(true);
                keterlindungan = 3;
                break;
            default:
                keterlindungan = 0;
                break;
        }
        switch (TempData.PENCEMAR){
            case 1:
                radio_pencemar_1.setChecked(true);
                pencemar = 1;
                break;
            case 2:
                radio_pencemar_2.setChecked(true);
                pencemar = 2;
                break;
            case 3:
                radio_pencemar_3.setChecked(true);
                pencemar = 3;
                break;
            default:
                pencemar = 0;
                break;
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
