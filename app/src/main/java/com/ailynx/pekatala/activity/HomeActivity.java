package com.ailynx.pekatala.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.ailynx.pekatala.adapter.TransaksiAdapter;
import com.ailynx.pekatala.R;
import com.ailynx.pekatala.controller.GetDataController;
import com.ailynx.pekatala.data.UserData;
import com.ailynx.pekatala.data.UserSettings;
import com.ailynx.pekatala.dialog.TeamDialog;
import com.ailynx.pekatala.model.Transaksi;
import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    CoordinatorLayout activity_home;
    RecyclerView rvHome;
    TextView text_nama_nav, text_username_nav, tvHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SugarContext.init(this);
        activity_home = (CoordinatorLayout) findViewById(R.id.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_home);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserData.transaksi = new Transaksi();
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        text_nama_nav = (TextView) navigationView.getHeaderView(0).findViewById(R.id.text_nama_nav);
        text_username_nav = (TextView) navigationView.getHeaderView(0).findViewById(R.id.text_username_nav);
        text_nama_nav.setText(UserData.NAMA);
        text_username_nav.setText("@" + UserData.USERNAME);
        navigationView.setNavigationItemSelectedListener(this);

        tvHome = (TextView) findViewById(R.id.tv_home);
        rvHome = (RecyclerView) findViewById(R.id.rv_home);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        rvHome.setLayoutManager(layoutManager);

        if (UserData.firstLogin == 1) {
            new syncData().execute();

            UserData.firstLogin = 0;
            UserSettings userSettings = UserSettings.newInstance(HomeActivity.this);
            userSettings.save();
        }
    }

    public void setData() {
        List<Transaksi> listTransaksi = Transaksi.listAll(Transaksi.class);
        if (listTransaksi.size() != 0) {
            final ArrayList<Transaksi> arrTransaksi = new ArrayList<>(listTransaksi);
            TransaksiAdapter adapter = new TransaksiAdapter(arrTransaksi, new TransaksiAdapter.onListItemClick() {
                @Override
                public void onItemClick(int position) {
                    UserData.transaksi = arrTransaksi.get(position);
                    Intent output = new Intent(HomeActivity.this, OutputActivity.class);
                    startActivity(output);
                }
            });
            rvHome.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
            rvHome.setAdapter(adapter);
            rvHome.setVisibility(View.VISIBLE);

            tvHome.setVisibility(View.GONE);
            Log.e("HomeActivity", "List size : "+listTransaksi.size());
        } else {
            rvHome.setVisibility(View.GONE);
            tvHome.setVisibility(View.VISIBLE);
            Log.e("HomeActivity", "No data ");
        }
    }

    class syncData extends AsyncTask<String, String, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(HomeActivity.this);
            progressDialog.setIndeterminate(false);
            progressDialog.setTitle("Sinkronisasi Data");
            progressDialog.setMessage("Tunggu sebentar...");
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressDialog.dismiss();
            if (s.equals("true")) {
                setData();
            } else if (s.equals("false")){
                Snackbar.make(activity_home, "Tidak ada data yang ditemukan.", Snackbar.LENGTH_SHORT).show();
            } else {
                Snackbar.make(activity_home, "Sinkronisasi data gagal.\nCoba ulang beberapa saat lagi.", Snackbar.LENGTH_SHORT).show();
            }
        }

        @Override
        protected String doInBackground(String... params) {
            GetDataController controller = new GetDataController();
            String result = controller.execute();
            if (result.equals("true")) {
                ArrayList<Transaksi> arrTransaksi = controller.getArrTransaksi();
                for (int i  = 0; i < arrTransaksi.size(); i++){
                    Transaksi transaksi = arrTransaksi.get(i);
                    transaksi.save();
                }
            }
            return result;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        setData();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            exit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_reset) {
            reset();
            return true;
        } else if (id == R.id.action_sync) {
            new syncData().execute();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_tentang) {
            Intent intent = new Intent(HomeActivity.this, TeamDialog.class);
            startActivity(intent);
        } else if (id == R.id.nav_logout) {
            logout();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void logout() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Logout")
                .setMessage("Apakah anda ingin logout dari aplikasi ini?")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        UserSettings userSettings = UserSettings.newInstance(HomeActivity.this);
                        userSettings.remove();
                        Transaksi.deleteAll(Transaksi.class);

                        UserData.firstLogin = 1;
                        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                        startActivity(intent);
                        HomeActivity.this.finish();
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        dialog.show();
    }

    private void exit() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Keluar")
                .setMessage("Apakah anda ingin keluar dari aplikasi ini?")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        HomeActivity.this.finish();
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        dialog.show();
    }

    private void reset() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Reset")
                .setMessage("Apakah anda ingin mereset semua data?")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Transaksi.deleteAll(Transaksi.class);
                        setData();
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        dialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SugarContext.terminate();
    }
}
