package com.example.toshiba.discountalertproject17;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.v4.app.FragmentManager;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Toshiba on 15-Aug-17.
 */

public class AlertNetworkListView extends AsyncTask<Void, Void, String> {
    String jsonresult;
    Activity context;

    public AlertNetworkListView(Activity context) {
        this.context = context;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        com.google.gson.Gson gson = new com.google.gson.Gson();

        List<alert> alerts = gson.fromJson(jsonresult, new TypeToken<ArrayList<alert>>() {
        }.getType());

        FragmentManager fragmentManager = ((MainActivity) context).getSupportFragmentManager();
        AlertListFragment alertListFragment = new AlertListFragment(context, alerts);
        fragmentManager.beginTransaction().replace(R.id.fragmentcontainer, alertListFragment).commit();
    }

    @Override
    protected String doInBackground(Void... params) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://projects17.dev:81/api/alert")
                .build();
        try {
            Response response = client.newCall(request).execute();
            jsonresult = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonresult;
    }
}
