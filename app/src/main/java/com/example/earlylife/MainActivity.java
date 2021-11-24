package com.example.earlylife;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.Begin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });
    }

    private boolean isConnected(MainActivity mainActivity) {
        ConnectivityManager connectivityManager = (ConnectivityManager) mainActivity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mobileDataConnection = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        NetworkInfo wifiConnection = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        if((wifiConnection!=null && wifiConnection.isConnected() || (mobileDataConnection!=null && mobileDataConnection.isConnected()))){
            return true;
        }
        else{
            return false;
        }
    }


//
//    public void fetchData(){
//
//        Call<List<Results>> call = RetrofitClient.getInstance().getMyApi().getLove();
//        call.enqueue(new Callback<List<Results>>() {
//
//
//            @Override
//            public void onResponse(Call<List<Results>> call, retrofit2.Response<List<Results>> response) {
//                List<Results> loveList = response.body();
//                String[] loveTime = new String[loveList.size()];
//
//                for (int i = 0; i < loveList.size(); i++) {
//                    loveTime[i] = loveList.get(i).getId();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Results>> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
//            }
//        });
//    }


    public void showCustomDialog() {
//        fetchData();
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
        alertBuilder.setMessage("Allow EarlyLife to connect to the internet or continue offline?. Your mobile data or Wifi will be consumed if you select to connect to the internet.").setCancelable(true).setPositiveButton("Continue Offline?", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(getApplicationContext(), TabbedActivity.class));
            }
        }).setNeutralButton("Connect Using Mobile Data?", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                if (isConnected(MainActivity.this)) {
                    startActivity(new Intent(getApplicationContext(), TabbedActivity.class));
                }
                else{
                    alertBuilder.setMessage("No Data Connection Available.").setCancelable(true).setPositiveButton("Continue Offline?", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(getApplicationContext(), TabbedActivity.class));
                        }
                    }).setNegativeButton("Try Again?", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //startActivity(new Intent(getApplicationContext(), TabbedActivity.class));
                            //startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            findViewById(R.id.Begin).performClick();
                            }
                        }).show();
                    }

                }

        }).setNegativeButton("Connect Using Wifi?", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                if(isConnected(MainActivity.this)){
                    startActivity(new Intent(getApplicationContext(), TabbedActivity.class));
                }
                else{
                    alertBuilder.setMessage("No Data Connection Available.").setCancelable(true).setPositiveButton("Continue Offline?", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(getApplicationContext(), TabbedActivity.class));
                        }
                    }).setNegativeButton("Try Again?", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //startActivity(new Intent(getApplicationContext(), TabbedActivity.class));
                            //startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            findViewById(R.id.Begin).performClick();
                        }
                    }).show();

                }

            }
        }).show();

    }
}