package com.example.toshiba.discountalertproject17;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapterAlert extends ArrayAdapter<alert> {

    private static LayoutInflater inflater;
    Activity activity;
    Context context;
    List<alert> alerts;

    public CustomAdapterAlert(@NonNull Context context, List<alert> alerts) {
        super(context, 0, alerts);
        this.alerts = alerts;
        activity = (Activity) context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        alert item = getItem(position);
        Holder holder = new Holder();
        View v;

        v = inflater.inflate(R.layout.activity_custom_adapter_alert, parent, false);
        holder.BankName = v.findViewById(R.id.card);
        holder.Discount = v.findViewById(R.id.discount);
        holder.Place = v.findViewById(R.id.place);

        holder.BankName.setText(alerts.get(position).getBname());
        holder.Discount.setText(alerts.get(position).getDiscount());
        holder.Place.setText(alerts.get(position).getPlace());

        return v;
    }

    public class Holder {
        TextView BankName;
        TextView Discount;
        TextView Place;

    }
}
