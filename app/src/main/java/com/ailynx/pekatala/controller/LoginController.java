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

public class LoginController {
    private String RESULT = "";
    private String SERVER_URL = "";
    private String URL = "";

    public String execute(){
        SERVER_URL = UserSettings.SERVER_URL;

        login();
        Log.e("Login-Pekatala", "Result Login: "+RESULT);
        return RESULT;
    }

    private void login(){
        URL = SERVER_URL+"login";
        Log.e("Login-Pekatala", URL);
        loginParser lparse = new loginParser();
        try {
            RESULT = lparse.run(URL);
        } catch (IOException e){
            RESULT = "network_error";
            e.printStackTrace();
        }
    }

    class loginParser {
        OkHttpClient client = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("username", UserData.USERNAME)
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
                resultTemp = temp.getString("login");
                UserData.NAMA = temp.getString("nama");
            } catch (JSONException e){
                resultTemp = "false";
                e.printStackTrace();
            }
            return resultTemp;
        }
    }
}
