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
            {"Surabaya", "Pasuruan", "Banyuwangi", "Sumenep"},
            {"Yogyakarta", "Jepara", "Semarang"},
            {"Bandung", "Bogor", "Cirebon"}
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
