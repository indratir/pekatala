package com.ailynx.pekatala.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ailynx.pekatala.R;
import com.ailynx.pekatala.data.UserData;
import com.ailynx.pekatala.data.UserSettings;
import com.ailynx.pekatala.controller.LoginController;
import com.ailynx.pekatala.controller.RegisterController;
import com.ailynx.pekatala.dialog.DateDialog;

public class LoginActivity extends AppCompatActivity {
    CoordinatorLayout activity_login;
    LinearLayout layout_login, layout_register;
    TextView text_register, text_login, text_tanggallahir_register;
    TextInputEditText text_username_login, text_password_login, text_nama_register, text_nohp_register, text_tempatlahir_register, text_username_register, text_password_register;
    Button btn_login, btn_register;
    
    public static String dateString = "Belum diatur";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        activity_login = (CoordinatorLayout) findViewById(R.id.activity_login);
        layout_login = (LinearLayout) findViewById(R.id.layout_login);
        layout_register = (LinearLayout) findViewById(R.id.layout_register);
        text_register = (TextView) findViewById(R.id.text_register);
        text_login = (TextView) findViewById(R.id.text_login);
        text_username_login = (TextInputEditText) findViewById(R.id.text_username_login);
        text_password_login = (TextInputEditText) findViewById(R.id.text_password_login);
        text_nama_register = (TextInputEditText) findViewById(R.id.text_nama_register);
        text_nohp_register = (TextInputEditText) findViewById(R.id.text_nohp_register);
        text_tempatlahir_register = (TextInputEditText) findViewById(R.id.text_tempatlahir_register);
        text_tanggallahir_register = (TextView) findViewById(R.id.text_tanggallahir_register);
        text_username_register = (TextInputEditText) findViewById(R.id.text_username_register);
        text_password_register = (TextInputEditText) findViewById(R.id.text_password_register);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_register = (Button) findViewById(R.id.btn_register);

        layout_register.setVisibility(View.GONE);
        text_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout_login.setVisibility(View.GONE);
                layout_register.setVisibility(View.VISIBLE);
            }
        });
        text_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout_login.setVisibility(View.VISIBLE);
                layout_register.setVisibility(View.GONE);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(text_username_login.getText()) || TextUtils.isEmpty(text_password_login.getText())){
                    Snackbar.make(activity_login, "Masukkan username & password anda.", Snackbar.LENGTH_SHORT).show();
                } else {
                    UserData.USERNAME = text_username_login.getText().toString();
                    UserData.PASSWORD = text_password_login.getText().toString();
                    new startLogin().execute();
                }
            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(text_nama_register.getText()) || TextUtils.isEmpty(text_nohp_register.getText()) || TextUtils.isEmpty(text_tempatlahir_register.getText()) || TextUtils.isEmpty(text_tanggallahir_register.getText()) || text_tanggallahir_register.getText().toString().equals("Belum diatur") || TextUtils.isEmpty(text_username_register.getText()) || TextUtils.isEmpty(text_password_register.getText())){
                    Snackbar.make(activity_login, "Masukkan data yang dibutuhkan untuk mendaftar akun.", Snackbar.LENGTH_SHORT).show();
                } else {
                    UserData.NAMA = text_nama_register.getText().toString();
                    UserData.NO_HP = text_nohp_register.getText().toString();
                    UserData.TANGGAL_LAHIR = text_tanggallahir_register.getText().toString();
                    UserData.TEMPAT_LAHIR = text_tempatlahir_register.getText().toString();
                    UserData.USERNAME = text_username_register.getText().toString();
                    UserData.PASSWORD = text_password_register.getText().toString();

                    new startRegist().execute();
                }
            }
        });
        text_tanggallahir_register.setText(dateString);
        text_tanggallahir_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, DateDialog.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        /*text_username_login.setText(UserData.USERNAME);
        text_password_login.setText(UserData.PASSWORD);
        text_username_register.setText(UserData.USERNAME);
        text_password_register.setText(UserData.PASSWORD);
        text_nama_register.setText(UserData.NAMA);
        text_nohp_register.setText(UserData.NO_HP);
        text_tempatlahir_register.setText(UserData.TEMPAT_LAHIR);*/
    }

    class startLogin extends AsyncTask<String, String, String>{
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(LoginActivity.this);
            progressDialog.setIndeterminate(false);
            progressDialog.setCancelable(true);
            progressDialog.setMessage("Tunggu sebentar...");
            progressDialog.setTitle("Login");
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();
            if (s.equals("true")){
                startIntent();
            } else if (s.equals("false")){
                Snackbar.make(activity_login, "Kombinasi username & password salah.", Snackbar.LENGTH_SHORT).show();
            } else {
                Snackbar.make(activity_login, "Cek koneksi internet anda.", Snackbar.LENGTH_SHORT).show();
            }
        }

        @Override
        protected String doInBackground(String... params) {
            LoginController controller = new LoginController();
            String result = controller.execute();
            return result;
        }
    }

    class startRegist extends AsyncTask<String, String, String>{
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(LoginActivity.this);
            progressDialog.setIndeterminate(false);
            progressDialog.setCancelable(true);
            progressDialog.setMessage("Tunggu sebentar...");
            progressDialog.setTitle("Mendaftar");
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();
            if (s.equals("true")){
                startIntent();
            } else if (s.equals("false")){
                Snackbar.make(activity_login, "Username yang anda masukkan telah digunakan.", Snackbar.LENGTH_SHORT).show();
            } else {
                Snackbar.make(activity_login, "Cek koneksi internet anda.", Snackbar.LENGTH_SHORT).show();
            }
        }

        @Override
        protected String doInBackground(String... params) {
            RegisterController controller = new RegisterController();
            String result = controller.execute();
            return result;
        }
    }

    private void startIntent(){
        UserSettings userSettings = UserSettings.newInstance(LoginActivity.this);
        userSettings.save();

        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
        LoginActivity.this.finish();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        text_tanggallahir_register.setText(dateString);
    }
}
