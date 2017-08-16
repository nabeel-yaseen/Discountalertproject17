package com.example.toshiba.discountalertproject17;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class loginFragment extends Fragment {

    private Context context;
    private EditText editusername, editpassword;
    private Button login;

    public loginFragment(Context context) {
        // Required empty public constructor
        this.context = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        editusername = v.findViewById(R.id.editusername);
        editpassword = v.findViewById(R.id.editpassword);
        login = v.findViewById(R.id.btnlogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editusername.getText().toString().equals("admin") && editpassword.getText().toString().equals("admin")) {

                    AlertNetworkListView alertNetworkListView = new AlertNetworkListView((Activity) context);
                    alertNetworkListView.execute();

                } else {
                    Toast.makeText(context, "Invalid Username or Password", Toast.LENGTH_SHORT).show();

                }
            }
        });
        return v;
    }

}
