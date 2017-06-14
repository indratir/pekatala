package com.ailynx.pekatala.data;

import com.ailynx.pekatala.model.Transaksi;

import java.util.ArrayList;

/**
 * Created by Indra Tirta Nugraha on 05/05/2017.
 */

public class UserData {
    public static int firstLogin = 1;
    public static String USERNAME = "";
    public static String NAMA = "";
    public static String NO_HP = "";
    public static String TEMPAT_LAHIR = "";
    public static String TANGGAL_LAHIR = "";
    public static String PASSWORD = "";

    public static Transaksi transaksi;
    public static String[] provinsi = {
            "Banten",
            "Jawa Barat",
            "Daerah Khusus Ibukota Jakarta",
            "Jawa Tengah",
            "Daerah Istimewa Yogyakarta",
            "Jawa Timur"
    };

    public static String[][] kota_kabupaten = {
            {
                    "Kab. Lebak",
                    "Kab. Pandeglang",
                    "Kab. Serang",
                    "Kab. Tangerang",
                    "Kota Cilegon",
                    "Kota Serang"
            },
            {
                    "Kab. Bekasi",
                    "Kab. Cianjur",
                    "Kab. Cirebon",
                    "Kab. Garut",
                    "Kab. Indramayu",
                    "Kab. Karawang",
                    "Kab. Pangandaran",
                    "Kab. Subang",
                    "Kota Cirebon"
            },
            {
                    "Kab. Kepulauan Seribu",
                    "Kota Jakarta Utara",
            },
            {
                    "Kab. Batang",
                    "Kab. Brebes",
                    "Kab. Cilacap",
                    "Kab. Demak",
                    "Kab. Jepara",
                    "Kab. Kebumen",
                    "Kab. Kendal",
                    "Kab. Pati",
                    "Kab. Pekalongan",
                    "Kab. Pemalang",
                    "Kab. Purworejo",
                    "Kab. Rembang",
                    "Kab. Tegal",
                    "Kab. Wonogiri",
                    "Kota Pekalongan",
                    "Kota Semarang",
                    "Kota Tegal"
            },
            {
                    "Kab. Bantul",
                    "Kab. Gunung Kidul",
                    "Kab. Kulon Progo"
            },
            {
                    "Kab. Bangkalan",
                    "Kab. Banyuwangi",
                    "Kab. Blitar",
                    "Kab. Gresik",
                    "Kab. Jember",
                    "Kab. Lamongan",
                    "Kab. Lumajang",
                    "Kab. Malang",
                    "Kab. Pacitan",
                    "Kab. Pamekasan",
                    "Kab. Pasuruan",
                    "Kab. Probolinggo",
                    "Kab. Sampang",
                    "Kab. Sidoarjo",
                    "Kab. Situbondo",
                    "Kab. Sumenep",
                    "Kab. Trenggalek",
                    "Kab. Tuban",
                    "Kab. Tulungagung",
                    "Kota Surabaya"
            }
    };
    public static String[] bulan = {
            "Januari", "Februari", "Maret", "April",
            "Mei", "Juni", "Juli", "Agustus",
            "September", "Oktober", "November", "Desember"
    };
    public static String[] waktu = {
            "Pagi",
            "Siang",
            "Sore",
            "Malam"
    };
}
