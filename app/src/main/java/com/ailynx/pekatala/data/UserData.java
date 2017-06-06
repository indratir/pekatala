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
            "Jawa Timur",
            "Jawa Tengah",
            "Jawa Barat"
    };
    public static String[][] kota_kabupaten = {
            {
                    "Kab. Bangkalan",
                    "Kab. Banyuwangi",
                    "Kab. Blitar",
                    "Kab. Bojonegoro",
                    "Kab. Bondowoso",
                    "Kab. Gresik",
                    "Kab. Jember",
                    "Kab. Jombang",
                    "Kab. Kediri",
                    "Kab. Lamongan",
                    "Kab. Lumajang",
                    "Kab. Madiun",
                    "Kab. Magetan",
                    "Kab. Malang",
                    "Kab. Mojokerto",
                    "Kab. Nganjuk",
                    "Kab. Ngawi",
                    "Kab. Pacitan",
                    "Kab. Pamekasan",
                    "Kab. Pasuruan",
                    "Kab. Ponorogo",
                    "Kab. Probolinggo",
                    "Kab. Sampang",
                    "Kab. Sidoarjo",
                    "Kab. Situbondo",
                    "Kab. Sumenep",
                    "Kab. Trenggalek",
                    "Kab. Tuban",
                    "Kab. Tulungagung",
                    "Kota Batu",
                    "Kota Blitar",
                    "Kota Kediri",
                    "Kota Madiun",
                    "Kota Malang",
                    "Kota Mojokerto",
                    "Kota Pasuruan",
                    "Kota Probolinggo",
                    "Kota Surabaya"
            },
            {
                    "Kab. Banjarnegara",
                    "Kab. Banyumas",
                    "Kab. Batang",
                    "Kab. Blora",
                    "Kab. Boyolali",
                    "Kab. Brebes",
                    "Kab. Cilacap",
                    "Kab. Demak",
                    "Kab. Grobogan",
                    "Kab. Jepara",
                    "Kab. Karanganyar",
                    "Kab. Kebumen",
                    "Kab. Kendal",
                    "Kab. Klaten",
                    "Kab. Kudus",
                    "Kab. Magelang",
                    "Kab. Pati",
                    "Kab. Pekalongan",
                    "Kab. Pemalang",
                    "Kab. Purbalingga",
                    "Kab. Purworejo",
                    "Kab. Rembang",
                    "Kab. Semarang",
                    "Kab. Sragen",
                    "Kab. Sukoharjo",
                    "Kab. Tegal",
                    "Kab. Temanggung",
                    "Kab. Wonogiri",
                    "Kab. Wonosobo",
                    "Kota Magelang",
                    "Kota Pekalongan",
                    "Kota Salatiga",
                    "Kota Semarang",
                    "Kota Surakarta",
                    "Kota Tegal"
            },
            {
                    "Kab. Bandung",
                    "Kab. Bandung Barat",
                    "Kab. Bekasi",
                    "Kab. Bogor",
                    "Kab. Ciamis",
                    "Kab. Cianjur",
                    "Kab. Cirebon",
                    "Kab. Garut",
                    "Kab. Indramayu",
                    "Kab. Karawang",
                    "Kab. Kuningan",
                    "Kab. Majalengka",
                    "Kab. Pangandaran",
                    "Kab. Purwakarta",
                    "Kab. Subang",
                    "Kab. Sukabumi",
                    "Kab. Sumedang",
                    "Kab. Tasikmalaya",
                    "Kota Bandung",
                    "Kota Banjar",
                    "Kota Bekasi",
                    "Kota Bogor",
                    "Kota Cimahi",
                    "Kota Cirebon",
                    "Kota Depok",
                    "Kota Sukabumi",
                    "Kota Tasikmalaya"
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
