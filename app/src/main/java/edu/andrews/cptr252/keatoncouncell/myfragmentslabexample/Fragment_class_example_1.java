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
        //TextView txtFragment1 = Fragment1View.findViewById(R.id.);
        //EditText editText = Fragment1View.findViewById(R.id.editText);


        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("info", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String name = sharedPreferences.getString("name","");







        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_class_example_1, container, false);
        return Fragment1View;
    }
}