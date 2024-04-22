package edu.andrews.cptr252.keatoncouncell.myfragmentslabexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Fragment_class_example_1 extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View Fragment1View = inflater.inflate(R.layout.fragment_class_example_1, container,false);
        ConstraintLayout constraintLayout = Fragment1View.findViewById(R.id.constrain_invisible);
        TextView txtFragment1 = Fragment1View.findViewById(R.id.fragment_1);
        EditText editText = Fragment1View.findViewById(R.id.editText);
        Button btnName = Fragment1View.findViewById(R.id.btnConfirm);
        Button btnNewUser = Fragment1View.findViewById(R.id.button);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("info", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String name = sharedPreferences.getString("name","");
        txtFragment1.setText("Welcome"+name);
        if(name.equals("")){
            constraintLayout.setVisibility(View.VISIBLE);
        }
        else{
            constraintLayout.setVisibility(View.INVISIBLE);
        }

        btnName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("name",editText.getText().toString());
                editor.apply();
                txtFragment1.setText("Welcome "+ editText.getText().toString());
                constraintLayout.setVisibility(View.INVISIBLE);
            }
        });

        btnNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("name","");
                editor.apply();
                txtFragment1.setText("Welcome ");
                constraintLayout.setVisibility(View.VISIBLE);
            }
        });


        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_class_example_1, container, false);
        return Fragment1View;
    }
}