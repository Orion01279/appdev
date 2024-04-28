package edu.andrews.cptr252.keatoncouncell.myfragmentslabexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;



public class Fragment_class_3 extends Fragment{

    String[] groceryStringList = {"apples", "avacados", "bananas", "broccoli",
            "grapes","lettuce", "onion",
            "orange","peppers","pineapple"};

    int[] iconList = {R.drawable.apples,R.drawable.avacadoes,R.drawable.banana
            ,R.drawable.broccoli,R.drawable.grape,R.drawable.lettuce
            ,R.drawable.onion,R.drawable.orange
            ,R.drawable.peppers,R.drawable.pineapple};



        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View Fragment3View = inflater.inflate(R.layout.fragment_3, container,false);
            //TextView txtFragment1 = Fragment3View.findViewById(R.id.fragment_3);

            ListView groceryList = Fragment3View.findViewById(R.id.Produce_Items);
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

            return Fragment3View;

        }
    }

