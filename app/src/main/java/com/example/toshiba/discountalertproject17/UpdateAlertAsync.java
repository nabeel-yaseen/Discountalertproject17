package com.example.toshiba.discountalertproject17;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Toshiba on 15-Aug-17.
 */

public class UpdateAlertAsync extends AsyncTask<Void, Void, String> {
    private Activity context;
    private String bname, discount, place;
    private String jsonresult;
    private int id;

    public UpdateAlertAsync(Activity context, String bname, String discount, String place, int id) {
        this.context = context;
        this.bname = bname;
        this.discount = discount;
        this.place = place;
        this.id = this.id;
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (s != null) {
            Toast.makeText(context, "updated successfully", Toast.LENGTH_SHORT).show();
            AlertNetworkListView networkListView = new AlertNetworkListView(context);
            networkListView.execute();
        } else
            Toast.makeText(context, "not updated", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected String doInBackground(Void... params) {

        OkHttpClient client = new OkHttpClient();

        RequestBody requestBody = new FormBody.Builder()
                .add("BankName", bname)
                .add("Discount", discount)
                .add("Place", place)
                .build();
        Request request = new Request.Builder()
                .url("http://projects17.dev:81/api/alert/" + id)
                .put(requestBody)
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
