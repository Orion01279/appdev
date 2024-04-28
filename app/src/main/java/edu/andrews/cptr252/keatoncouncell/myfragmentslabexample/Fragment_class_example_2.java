package edu.andrews.cptr252.keatoncouncell.myfragmentslabexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;


public class Fragment_class_example_2 extends Fragment {




    String[] groceryStringList = {"canned goods", "cereal", "chips", "gatorade", "granola bars","pasta", "popcorn","sauce","seasoning","cooking oil"};

    int[] iconList = {R.drawable.canned_goods,R.drawable.cereal,R.drawable.chips,R.drawable.gatorade
            ,R.drawable.granola_bar,R.drawable.pasta,R.drawable.popcorn,R.drawable.sauce
            ,R.drawable.seasoning,R.drawable.vegetable_oil};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View Fragment2View = inflater.inflate(R.layout.fragment_class_example_2, container,false);
        //TextView txtFragment1 = Fragment2View.findViewById(R.id.fragment_2);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("info", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();


        ListView groceryList = Fragment2View.findViewById(R.id.Grocery_Items);
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

        return Fragment2View;

    }
}

class ViewProduct{
    ImageView icon;
    TextView title;
}

class ProductData {
    private int icon;
    private String title;


    public ProductData(int icon, String title) {
        this.icon = icon;

        this.title = title;
    }


    public int getIcon() {
        return icon;

    }

    public String getTitle() {
        return title;
    }

}
class MyAdapter extends ArrayAdapter {
    public MyAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // return super.getView(position, convertView, parent);
        View myView = convertView;
        ViewProduct viewAnimal;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            myView = inflater.inflate(R.layout.product_cell, parent, false);

            viewAnimal = new ViewProduct();
            viewAnimal.icon = (ImageView) myView.findViewById(R.id.icon);
            viewAnimal.title = (TextView) myView.findViewById(R.id.title);


            myView.setTag(viewAnimal);

        } else {
            viewAnimal = (ViewProduct) myView.getTag();
        }

        ProductData animalData = (ProductData) this.getItem(position);
        viewAnimal.icon.setImageResource(animalData.getIcon());
        viewAnimal.title.setText(animalData.getTitle());


        return myView;


    }

}