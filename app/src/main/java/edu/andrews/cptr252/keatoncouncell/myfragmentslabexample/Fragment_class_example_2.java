package edu.andrews.cptr252.keatoncouncell.myfragmentslabexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;


public class Fragment_class_example_2 extends Fragment {



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

        View Fragment2View = inflater.inflate(R.layout.fragment_class_example_2, container,false);
        //TextView txtFragment1 = Fragment2View.findViewById(R.id.fragment_2);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("info", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        icon1 = ContextCompat.getDrawable(getActivity(),R.drawable.canned_goods);
        icon2 = ContextCompat.getDrawable(getActivity(),R.drawable.cereal);
        icon3 = ContextCompat.getDrawable(getActivity(),R.drawable.chips);
        icon4 = ContextCompat.getDrawable(getActivity(),R.drawable.gatorade);
        icon5 = ContextCompat.getDrawable(getActivity(),R.drawable.granola_bar);
        icon6 = ContextCompat.getDrawable(getActivity(),R.drawable.pasta);
        icon7 = ContextCompat.getDrawable(getActivity(),R.drawable.popcorn);
        icon8 = ContextCompat.getDrawable(getActivity(),R.drawable.sauce);
        icon9 = ContextCompat.getDrawable(getActivity(),R.drawable.seasoning);
        icon10 = ContextCompat.getDrawable(getActivity(),R.drawable.vegetable_oil);

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_class_example_1, container, false);

        return Fragment2View;

    }
}