package com.ailynx.pekatala.controller;

import android.util.Log;

import com.ailynx.pekatala.data.UserData;
import com.ailynx.pekatala.data.UserSettings;
import com.ailynx.pekatala.model.Transaksi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Indra Tirta Nugraha on 09/05/2017.
 */

public class GetDataController {
    private String RESULT = "";
    private String SERVER_URL = "";
    private String URL = "";
    private ArrayList<Transaksi> arrTransaksi;

    public GetDataController(){
        arrTransaksi = new ArrayList<>();
    }
    public String execute(){
        SERVER_URL = UserSettings.SERVER_URL;
        gettingData();
        Log.e("Get-Pekatala", "Result Get: "+RESULT);
        return RESULT;
    }

    private void gettingData(){
        URL = SERVER_URL + "data/" + UserData.USERNAME;
        Log.e("Get-Pekatala", URL);
        getParser parser = new getParser();
        try {
            RESULT = parser.run(URL);
        } catch (IOException e){
            RESULT = "network_error";
            e.printStackTrace();
        }
    }

    class getParser {
        OkHttpClient client = new OkHttpClient();
        String run(String url) throws IOException {
            client.cache();
            Request request = new Request.Builder()
                .url(url)
                .build();
            Response response = client.newCall(request).execute();
            String result = verifyJson(response.body().string());
            return result;
        }
        public String verifyJson(String data){
            JSONArray jsonArray;
            JSONObject jsonObject;
            String resultTemp;
            Log.e("Get-Pekatala", data);
            try {
                jsonObject = new JSONObject(data);
                jsonArray = jsonObject.getJSONArray("data");
                int count = jsonArray.length();
                Log.e("Get-Pekatala", "Count Transaksi "+count);
                for (int i = 0; i < count; i++){
                    jsonObject = jsonArray.getJSONObject(i);
                    Log.e("Get-Pekatala", jsonObject.toString());
                    Transaksi transaksi = new Transaksi();
                    transaksi.setId(jsonObject.getLong("id"));
                    transaksi.setPernah_tanam(jsonObject.getInt("pernah_tanam"));
                    transaksi.setHama_ikan(jsonObject.getInt("hama_ikan"));
                    transaksi.setHama_gulma(jsonObject.getInt("hama_gulma"));
                    transaksi.setPenyakit_iceice(jsonObject.getInt("penyakit_iceice"));
                    transaksi.setSalinitas(jsonObject.getInt("salinitas"));
                    transaksi.setKecerahan(jsonObject.getInt("kecerahan"));
                    transaksi.setSuhu(jsonObject.getInt("suhu"));
                    transaksi.setKedalaman(jsonObject.getInt("kedalaman"));
                    transaksi.setKecepatan_arus(jsonObject.getInt("kecepatan_arus"));
                    transaksi.setSubstrat_dasar_pantai(jsonObject.getInt("substrat_dasar_pantai"));
                    transaksi.setKeterlindungan(jsonObject.getInt("keterlindungan"));
                    transaksi.setKeterjangkauan(jsonObject.getInt("keterjangkauan"));
                    transaksi.setPencemar(jsonObject.getInt("pencemar"));
                    transaksi.setProvinsi(jsonObject.getInt("provinsi"));
                    transaksi.setKota_kabupaten(jsonObject.getInt("kota_kabupaten"));
                    transaksi.setBulan(jsonObject.getInt("bulan"));
                    transaksi.setWaktu(jsonObject.getInt("waktu"));
                    arrTransaksi.add(transaksi);
                }
                resultTemp = "true";
            } catch (JSONException e){
                resultTemp = "false";
                e.printStackTrace();
            }
            return resultTemp;
        }
    }

    public ArrayList<Transaksi> getArrTransaksi() {
        return arrTransaksi;
    }
}
