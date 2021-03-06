package com.ailynx.pekatala.model;

import android.content.Context;
import android.util.Log;

import com.ailynx.pekatala.R;
import com.ailynx.pekatala.data.UserData;
import com.orm.SugarRecord;

/**
 * Created by Indra Tirta Nugraha on 22/05/2017.
 */

public class Transaksi extends SugarRecord {

    int pernah_tanam;
    int hama_ikan;
    int hama_gulma;
    int penyakit_iceice;
    int bulan;
    int waktu;
    int provinsi;
    int kota_kabupaten;

    int salinitas;
    int kecerahan;
    int suhu;
    int kedalaman;
    int substrat_dasar_pantai;

    public Transaksi() {
    }

    public Transaksi(int pernah_tanam,
                     int hama_ikan,
                     int hama_gulma,
                     int penyakit_iceice,
                     int bulan, int waktu,
                     int provinsi,
                     int kota_kabupaten,
                     int salinitas,
                     int kecerahan,
                     int suhu,
                     int kedalaman,
                     int substrat_dasar_pantai) {

        this.pernah_tanam = pernah_tanam;
        this.hama_ikan = hama_ikan;
        this.hama_gulma = hama_gulma;
        this.penyakit_iceice = penyakit_iceice;
        this.bulan = bulan;
        this.waktu = waktu;
        this.provinsi = provinsi;
        this.kota_kabupaten = kota_kabupaten;
        this.salinitas = salinitas;
        this.kecerahan = kecerahan;
        this.suhu = suhu;
        this.kedalaman = kedalaman;
        this.substrat_dasar_pantai = substrat_dasar_pantai;
    }

    public int getLogoId() {
        double hasil = 0;
        if (pernah_tanam == 1) {
            hasil = salinitas + kecerahan + suhu;
            hasil = hasil / 3;
        } else {
            hasil = salinitas + kecerahan + suhu +
                    kedalaman + substrat_dasar_pantai;
            hasil = hasil / 5;
        }

        Log.e("Transaksi", "Hasil : "+hasil);

        if (hasil >= 2.3) {
            return R.drawable.logo_baik;
        } else if (hasil >= 1.7 && hasil <= 2.2) {
            return R.drawable.logo_cukup;
        } else if (hasil <= 1.6) {
            return R.drawable.logo_buruk;
        } else {
            return 0;
        }
    }

    public String getTitle() {
        String provinsi = UserData.provinsi[this.provinsi - 1];
        String kota_kabupaten = UserData.kota_kabupaten[this.provinsi - 1][this.kota_kabupaten - 1];
        return kota_kabupaten + ", " + provinsi;
    }

    public String getSubtitle() {
        String bulan = UserData.bulan[this.bulan - 1];
        String waktu = UserData.waktu[this.waktu - 1];
        return bulan + " (" + waktu + ")";
    }

    public String getInfo() {
        double hasil = 0;
        if (pernah_tanam == 1) {
            hasil = salinitas + kecerahan + suhu;
            hasil = hasil / 3;
        } else {
            hasil = salinitas + kecerahan + suhu +
                    kedalaman + substrat_dasar_pantai;
            hasil = hasil / 5;
        }

        Log.e("Transaksi", "Hasil : "+hasil);

        String result = "";
        if (hasil >= 2.3) {
            result = "Baik";
        } else if (hasil >= 1.7 && hasil <= 2.2) {
            result = "Cukup";
        } else if (hasil <= 1.6) {
            result = "Buruk";
        }

        return result;
    }

    public String getSaran(Context context) {
        String result = "Waktu tanam :\n";

        if (bulan == 1 || bulan == 2){
            result += context.getString(R.string.saran_januari_februari) + "\n";
        }
        if (bulan == 3 || bulan == 4 || bulan == 5) {
            result += context.getString(R.string.saran_maret_april_mei) + "\n";
        }
        if  (bulan == 5 || bulan == 6) {
            result += context.getString(R.string.saran_mei_juni) + "\n";
        }
        if (bulan == 7 || bulan == 8 || bulan == 9) {
            result += context.getString(R.string.saran_juli_agustus_september) + "\n";
        }
        if (bulan == 8 || bulan == 9) {
            result += context.getString(R.string.saran_agustus_september) + "\n";
        }

        if (waktu == 1) {
            result += context.getString(R.string.saran_pagi) + "\n";
        } else if (waktu == 2) {
            result += context.getString(R.string.saran_siang) + "\n";
        } else if (waktu == 3) {
            result += context.getString(R.string.saran_sore) + "\n";
        } else if (waktu == 2) {
            result += context.getString(R.string.saran_malam) + "\n";
        }

        result += "\nKualitas Air :\n";

        switch (salinitas) {
            case 1:
                result += "- " + context.getString(R.string.saran_salinitas_1) + "\n";
                break;
            case 2:
                result += "- " + context.getString(R.string.saran_salinitas_2) + "\n";
                break;
            default:
                break;
        }

        switch (kecerahan) {
            case 1:
                result += "- " + context.getString(R.string.saran_kecerahan_1) + "\n";
                break;
            case 2:
                result += "- " + context.getString(R.string.saran_kecerahan_2) + "\n";
                break;
            default:
                break;
        }

        switch (suhu) {
            case 1:
                result += "- " + context.getString(R.string.saran_suhu_1) + "\n";
                break;
            case 2:
                result += "- " + context.getString(R.string.saran_suhu_2) + "\n";
                break;
            default:
                break;
        }

        switch (kedalaman) {
            case 1:
                result += "- " + context.getString(R.string.saran_kedalaman_1) + "\n";
                break;
            case 2:
                result += "- " + context.getString(R.string.saran_kedalaman_2) + "\n";
                break;
            default:
                break;
        }

        switch (substrat_dasar_pantai) {
            case 1:
                result += "- " + context.getString(R.string.saran_substratdasarpantai_1) + "\n";
                break;
            case 2:
                result += "- " + context.getString(R.string.saran_substratdasarpantai_2) + "\n";
                break;
            default:
                break;
        }

        result += "\nHama & Penyakit :\n";

        if (hama_ikan == 0 && hama_gulma == 0 && penyakit_iceice == 0){
            result += context.getString(R.string.saran_hamapenyakit_000) + "\n";
        } else if (hama_ikan == 0 && hama_gulma == 0 && penyakit_iceice == 1){
            result += context.getString(R.string.saran_hamapenyakit_001) + "\n";
        } else if (hama_ikan == 0 && hama_gulma == 1 && penyakit_iceice == 1){
            result += context.getString(R.string.saran_hamapenyakit_011) + "\n";
        } else if (hama_ikan == 1 && hama_gulma == 1 && penyakit_iceice == 1){
            result += context.getString(R.string.saran_hamapenyakit_111) + "\n";
        }

        return result;
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    public void setPernah_tanam(int pernah_tanam) {
        this.pernah_tanam = pernah_tanam;
    }

    public void setHama_ikan(int hama_ikan) {
        this.hama_ikan = hama_ikan;
    }

    public void setHama_gulma(int hama_gulma) {
        this.hama_gulma = hama_gulma;
    }

    public void setPenyakit_iceice(int penyakit_iceice) {
        this.penyakit_iceice = penyakit_iceice;
    }

    public void setBulan(int bulan) {
        this.bulan = bulan;
    }

    public void setWaktu(int waktu) {
        this.waktu = waktu;
    }

    public void setProvinsi(int provinsi) {
        this.provinsi = provinsi;
    }

    public void setKota_kabupaten(int kota_kabupaten) {
        this.kota_kabupaten = kota_kabupaten;
    }

    public void setSalinitas(int salinitas) {
        this.salinitas = salinitas;
    }

    public void setKecerahan(int kecerahan) {
        this.kecerahan = kecerahan;
    }

    public void setSuhu(int suhu) {
        this.suhu = suhu;
    }

    public void setKedalaman(int kedalaman) {
        this.kedalaman = kedalaman;
    }

    public void setSubstrat_dasar_pantai(int substrat_dasar_pantai) {
        this.substrat_dasar_pantai = substrat_dasar_pantai;
    }

    public int getPernah_tanam() {
        return pernah_tanam;
    }

    public int getHama_ikan() {
        return hama_ikan;
    }

    public int getHama_gulma() {
        return hama_gulma;
    }

    public int getPenyakit_iceice() {
        return penyakit_iceice;
    }

    public int getBulan() {
        return bulan;
    }

    public int getWaktu() {
        return waktu;
    }

    public int getProvinsi() {
        return provinsi;
    }

    public int getKota_kabupaten() {
        return kota_kabupaten;
    }

    public int getSalinitas() {
        return salinitas;
    }

    public int getKecerahan() {
        return kecerahan;
    }

    public int getSuhu() {
        return suhu;
    }

    public int getKedalaman() {
        return kedalaman;
    }

    public int getSubstrat_dasar_pantai() {
        return substrat_dasar_pantai;
    }
}
