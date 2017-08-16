package com.example.toshiba.discountalertproject17;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.IOError;
import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Toshiba on 15-Aug-17.
 */

public class DeleteAlertAsync extends AsyncTask<Void,Void,String> {

    String jsonresult;
    private Activity context;
    private int id;

    public DeleteAlertAsync(Activity context, int id) {
        this.context = context;
        this.id = id;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        if (s!=null){
            Toast.makeText(context, "Deleted Successfully", Toast.LENGTH_SHORT).show();
            AlertNetworkListView networkListView = new AlertNetworkListView(context);
            networkListView.execute();
        }else
            Toast.makeText(context, "Not Deleted", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected String doInBackground(Void... params) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://projects17.dev:81/api/alert/"+id)
                .delete()
                .build();
        try {
            Response response = client.newCall(request).execute();
            jsonresult = response.body().string();
        } catch (IOException e){
            e.printStackTrace();
        }
        return jsonresult;
    }
}
