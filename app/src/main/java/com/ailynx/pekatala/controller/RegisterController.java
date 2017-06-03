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

public class RegisterController {
    private String RESULT = "";
    private String SERVER_URL = "";
    private String URL = "";

    public String execute(){
        SERVER_URL = UserSettings.SERVER_URL;
        regist();
        Log.e("Register-Pekatala", "Result Register: "+RESULT);
        return RESULT;
    }

    private void regist(){
        URL = SERVER_URL+"register";
        Log.e("Register-Pekatala", URL);
        registParser lparse = new registParser();
        try {
            RESULT = lparse.run(URL);
        } catch (IOException e){
            RESULT = "NETWORK_ERROR";
            e.printStackTrace();
        }
    }

    class registParser {
        OkHttpClient client = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("username", UserData.USERNAME)
                .add("nama", UserData.NAMA)
                .add("nohp", UserData.NO_HP)
                .add("tempat_lahir", UserData.TEMPAT_LAHIR)
                .add("tanggal_lahir", UserData.TANGGAL_LAHIR)
                .add("password", UserData.PASSWORD)
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
            JSONObject temp;
            String resultTemp;
            try {
                temp = new JSONObject(data);
                resultTemp = temp.getString("register");
            } catch (JSONException e){
                resultTemp = null;
                e.printStackTrace();
            }
            return resultTemp;
        }
    }
}
