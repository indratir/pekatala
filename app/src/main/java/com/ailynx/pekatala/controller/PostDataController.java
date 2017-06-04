package com.ailynx.pekatala.controller;

import android.util.Log;

import com.ailynx.pekatala.data.UserData;
import com.ailynx.pekatala.data.UserSettings;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Indra Tirta Nugraha on 08/05/2017.
 */

public class PostDataController {
    private String RESULT = "";
    private String SERVER_URL = "";
    private String URL = "";

    public String execute(){
        SERVER_URL = UserSettings.SERVER_URL;
        postingData();
        Log.e("Post-Pekatala", "Result Post: "+RESULT);
        return RESULT;
    }

    private void postingData(){
        URL = SERVER_URL+"data";
        Log.e("Post-Pekatala", URL);
        postParser parser = new postParser();
        try {
            RESULT = parser.run(URL);
        } catch (IOException e){
            RESULT = "network_error";
            e.printStackTrace();
        }
    }

    class postParser {
        OkHttpClient client = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("username", UserData.USERNAME)
                .add("pernah_tanam", ""+ UserData.transaksi.getPernah_tanam())
                .add("hama_ikan", ""+ UserData.transaksi.getHama_ikan())
                .add("hama_gulma", ""+UserData.transaksi.getHama_gulma())
                .add("penyakit_iceice", ""+UserData.transaksi.getPenyakit_iceice())
                .add("salinitas", ""+UserData.transaksi.getSalinitas())
                .add("kecerahan", ""+UserData.transaksi.getKecerahan())
                .add("suhu", ""+UserData.transaksi.getSuhu())
                .add("kedalaman", ""+UserData.transaksi.getKedalaman())
                .add("substrat_dasar_pantai", ""+UserData.transaksi.getSubstrat_dasar_pantai())
                .add("provinsi", ""+UserData.transaksi.getProvinsi())
                .add("kota_kabupaten", ""+UserData.transaksi.getKota_kabupaten())
                .add("bulan", ""+UserData.transaksi.getBulan())
                .add("waktu", ""+UserData.transaksi.getWaktu())
                .build();
        String run(String url) throws IOException {
            client.cache();
            Request request = new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .build();
            Response response = client.newCall(request).execute();
            String result = verifyJson(response.body().string());
            return result;
        }
        public String verifyJson(String data){
            Log.e("Post-Pekatala", data);
            JSONObject temp;
            String resultTemp;
            try {
                temp = new JSONObject(data);
                resultTemp = temp.getString("status");

                String idStr = temp.getString("id");
                if (idStr != null) {
                    Long id = Long.parseLong(idStr);
                    UserData.transaksi.setId(id);
                }
            } catch (JSONException e){
                resultTemp = "json_error";
                e.printStackTrace();
            }
            return resultTemp;
        }
    }
}
