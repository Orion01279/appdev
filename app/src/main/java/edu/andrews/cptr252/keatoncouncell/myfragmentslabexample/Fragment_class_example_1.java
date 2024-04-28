package edu.andrews.cptr252.keatoncouncell.myfragmentslabexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class Fragment_class_example_1 extends Fragment {

    String[] groceryStringList = {"vegetarian meat", "french fries", "frozen meals",
            "frozen pizza", "frozen spices","frozen fruit",
            "frozen vegetables","popsicles","ice cream","waffles"};

    int[] iconList = {R.drawable.breakfast_patty,R.drawable.french_fries,R.drawable.frozen_meal,
            R.drawable.frozen_pizza,R.drawable.frozen_spices,R.drawable.mix_fruit,
            R.drawable.mix_vegetable,R.drawable.popsicle
            ,R.drawable.vanilla,R.drawable.waffles};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View Fragment1View = inflater.inflate(R.layout.fragment_class_example_1, container,false);
        //TextView txtFragment1 = Fragment1View.findViewById(R.id.);
        //EditText editText = Fragment1View.findViewById(R.id.editText);

        ListView groceryList = Fragment1View.findViewById(R.id.Frozen_Items);
        //TextView groceryText = Fragment2View.findViewById(R.id.Category_Grocery);
        MyAdapter myAdapter = new MyAdapter(getActivity(),R.layout.product_cell);


        for(int i=0; i<groceryStringList.length;i++){
            ProductData productData;
            productData = new ProductData(iconList[i],groceryStringList[i]);
            myAdapter.add(productData);
        }
        groceryList.setAdapter(myAdapter);







        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_class_example_1, container, false);
        return Fragment1View;
    }
}

