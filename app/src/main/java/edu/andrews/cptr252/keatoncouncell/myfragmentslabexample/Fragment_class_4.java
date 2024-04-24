package edu.andrews.cptr252.keatoncouncell.myfragmentslabexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class Fragment_class_4 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View Fragment4View = inflater.inflate(R.layout.fragment_4_edit, container,false);
        //TextView txtFragment1 = Fragment3View.findViewById(R.id.fragment_3);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("info", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();



        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_class_example_1, container, false);

        return Fragment4View;

    }


}
