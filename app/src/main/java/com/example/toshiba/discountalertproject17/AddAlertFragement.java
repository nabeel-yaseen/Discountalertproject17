package com.example.toshiba.discountalertproject17;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddAlertFragement extends Fragment {

    private Activity context;
    private TextView textView;
    private EditText bname, discount, place;
    private Button btnsave;

    public AddAlertFragement(Activity context, String s, String toString, String string) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add_alert_fragement, container, false);
        textView = v.findViewById(R.id.textdetail);
        bname = v.findViewById(R.id.editbank);
        discount = v.findViewById(R.id.editdiscount);
        place = v.findViewById(R.id.editplace);
        btnsave = v.findViewById(R.id.btnsave);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddAlertAsync addAlertAsync = new AddAlertAsync(context, bname.getText().toString(), discount.getText()
                        .toString(), place.getText().toString());
                addAlertAsync.execute();
            }
        });
        return v;
    }

}
