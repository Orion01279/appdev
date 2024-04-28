package edu.andrews.cptr252.keatoncouncell.myfragmentslabexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class Fragment_class_3 extends Fragment{



    private Drawable icon1;
    private Drawable icon2;
    private Drawable icon3;
    private Drawable icon4;
    private Drawable icon5;
    private Drawable icon6;
    private Drawable icon7;
    private Drawable icon8;
    private Drawable icon9;
    private Drawable icon10;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View Fragment3View = inflater.inflate(R.layout.fragment_3, container,false);
            //TextView txtFragment1 = Fragment3View.findViewById(R.id.fragment_3);

            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("info", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            icon1 = ContextCompat.getDrawable(getActivity(),R.drawable.apples);
            icon2 = ContextCompat.getDrawable(getActivity(),R.drawable.avacadoes);
            icon3 = ContextCompat.getDrawable(getActivity(),R.drawable.banana);
            icon4 = ContextCompat.getDrawable(getActivity(),R.drawable.broccoli);
            icon5 = ContextCompat.getDrawable(getActivity(),R.drawable.grape);
            icon6 = ContextCompat.getDrawable(getActivity(),R.drawable.lettuce);
            icon7 = ContextCompat.getDrawable(getActivity(),R.drawable.onion);
            icon8 = ContextCompat.getDrawable(getActivity(),R.drawable.orange);
            icon9 = ContextCompat.getDrawable(getActivity(),R.drawable.peppers);
            icon10 = ContextCompat.getDrawable(getActivity(),R.drawable.pineapple);


            // Inflate the layout for this fragment
            //return inflater.inflate(R.layout.fragment_class_example_1, container, false);

            return Fragment3View;

        }
    }

