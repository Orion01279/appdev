package edu.andrews.cptr252.keatoncouncell.myfragmentslabexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Fragment_class_example_1 extends Fragment {

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
        View Fragment1View = inflater.inflate(R.layout.fragment_class_example_1, container,false);
        //TextView txtFragment1 = Fragment1View.findViewById(R.id.);
        //EditText editText = Fragment1View.findViewById(R.id.editText);
        icon1 = ContextCompat.getDrawable(getActivity(),R.drawable.breakfast_patty);
        icon2 = ContextCompat.getDrawable(getActivity(),R.drawable.french_fries);
        icon3 = ContextCompat.getDrawable(getActivity(),R.drawable.frozen_meal);
        icon4 = ContextCompat.getDrawable(getActivity(),R.drawable.frozen_pizza);
        icon5 = ContextCompat.getDrawable(getActivity(),R.drawable.frozen_spices);
        icon6 = ContextCompat.getDrawable(getActivity(),R.drawable.mix_fruit);
        icon7 = ContextCompat.getDrawable(getActivity(),R.drawable.mix_vegetable);
        icon8 = ContextCompat.getDrawable(getActivity(),R.drawable.popsicle);
        icon9 = ContextCompat.getDrawable(getActivity(),R.drawable.vanilla);
        icon10 = ContextCompat.getDrawable(getActivity(),R.drawable.waffles);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("info", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String name = sharedPreferences.getString("name","");







        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_class_example_1, container, false);
        return Fragment1View;
    }
}