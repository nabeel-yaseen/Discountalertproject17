package com.example.toshiba.discountalertproject17;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateAlertFragment extends Fragment {

    private Activity context;
    private Button btnedit;
    private EditText edtbname, edtdiscount, edtplace;
    private String bname, discount, place;
    private int id;

    public UpdateAlertFragment(Activity context, String bname, String discount, String place, int id) {
        this.context = context;
        this.bname = bname;
        this.discount = discount;
        this.place = place;
        this.id = id;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_update_alert, container, false);
        edtbname = v.findViewById(R.id.editbname);
        edtdiscount = v.findViewById(R.id.editdiscount);
        edtplace = v.findViewById(R.id.editplace);
        btnedit = v.findViewById(R.id.btnupdate);

        edtbname.setText(bname);
        edtdiscount.setText(discount);
        edtplace.setText(place);

        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateAlertAsync updateAlertAsync = new UpdateAlertAsync(context, edtbname.getText().toString(),
                        edtdiscount.getText().toString(), edtplace.getText().toString(), id);
                updateAlertAsync.execute();
            }
        });
        return v;
    }

}
