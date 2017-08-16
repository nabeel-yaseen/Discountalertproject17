package com.example.toshiba.discountalertproject17;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlertListFragment extends Fragment {
    private Activity context;
    private List<alert> alerts;
    private Button addstudent;
    private ListView listviewalert;


    public AlertListFragment(Activity context, List<alert> alerts) {
        // Required empty public constructor
        this.alerts = alerts;
        this.context = context;
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_alert_list, container, false);

        listviewalert = v.findViewById(R.id.listviewcard);
        addstudent = v.findViewById(R.id.btnadd);

        CustomAdapterAlert customAdapterAlert = new CustomAdapterAlert(context, alerts);
        listviewalert.setAdapter(customAdapterAlert);

        listviewalert.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(context, AlertViewActivity.class);

                intent.putExtra("bname", alerts.get(i).getBname());
                intent.putExtra("discount", alerts.get(i).getDiscount());
                intent.putExtra("place", alerts.get(i).getPlace());
                startActivity(intent);
            }
        });
        listviewalert.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                //  Toast.makeText(context,"LONG CLICK PRESS",Toast.LENGTH_LONG).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("What do you want ??")
                        .setCancelable(false)
                        .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                UpdateAlertFragment updateTeacherFragment = new UpdateAlertFragment(context,
                                        alerts.get(position).getBname(),
                                        alerts.get(position).getDiscount(),
                                        alerts.get(position).getPlace(),
                                        alerts.get(position).getId()
                                );

                                FragmentManager fragmentManager = ((MainActivity) context).getSupportFragmentManager();
                                fragmentManager.beginTransaction().replace(R.id.fragmentcontainer, updateTeacherFragment).commit();
                                // Toast.makeText(context,"U Call",Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        DeleteAlertAsync deleteTeacherAsync = new DeleteAlertAsync(context, alerts.get(position).getId());
                        deleteTeacherAsync.execute();

                    }
                }).setCancelable(true);
                AlertDialog alert = builder.create();
                alert.setTitle("Done");
                alert.show();
                return true;
            }
        });
        return v;
    }

}
